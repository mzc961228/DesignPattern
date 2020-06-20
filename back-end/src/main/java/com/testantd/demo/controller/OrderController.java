package com.testantd.demo.controller;

import com.testantd.demo.bean.*;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@RestController
@RequestMapping(value = "api/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SettingService settingService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderGoodsService orderGoodsService;


    /**
     *  提交订单 order/submit
     * @Author liuxin
     * */
    @PostMapping(value = "order/submit")
    public MyResponse orderSubmit(@RequestBody Map<String,Object> params){
        try {
            // 获取收货地址信息和计算运费
            Integer userId = (Integer) params.get("userId");
            Integer addressId = (Integer) params.get("addressId");
            Integer freightPrice = (Integer) params.get("freightPrice");
            Integer offlinePay = (Integer) params.get("offlinePay");
            String postscript = (String) params.get("postscript");

            Address address = addressService.getAddressById(addressId);

            // 获取要购买的商品
            List<Cart> cartList = cartService.getCartSelected(userId);
            if (cartList.size() <= 0){
                return new MyResponse().errno(1).stateCode("error").message("请选择商品");
            }
            Float checkPrice = new Float(0),checkStock = new Float(0);
            for (Cart cart:cartList) {
                System.out.println(cart);
                Product product = productService.selectById(cart.getProduct_id());
                if(cart.getNumber() > product.getGoods_number()){
                    checkStock++;
                }
//                System.out.println("cart.getRetail_price():"+cart.getRetail_price());
//                System.out.println("cart.getAdd_price():"+cart.getAdd_price());
//                if(Math.abs(cart.getRetail_price()-cart.getAdd_price())<=0 ){
//                    checkPrice++;
//                }
            }
            if(checkStock > 0){
                return new MyResponse().errno(1).stateCode("error").message("库存不足，请重新下单");
            }
//            if(checkPrice > 0){
//                return new MyResponse().errno(1).stateCode("error").message("价格发生变化，请重新下单");
//            }

            // 获取订单使用的红包
            // 如果有用红包，则将红包的数量减少，当减到0时，将该条红包删除
            // 统计商品总价
            Float goodsTotalPrice = new Float(0);
            for (Cart cart:cartList) {
                goodsTotalPrice += cart.getNumber() * cart.getRetail_price();
            }
            // 订单价格计算
            Float orderTotalPrice = goodsTotalPrice + freightPrice; // 订单的总价
            double actualPrice = orderTotalPrice - 0.00; // 减去其它支付的金额后，要实际支付的金额 比如满减等优惠
            Long currentTime = new Date().getTime()/1000;
            String print_info = "";
            int i = 0;
            for (Cart cart:cartList) {
                i++;
                print_info = print_info + i + '、' + cart.getGoods_aka() + '【' + cart.getNumber() + "】 ";
            }

            Setting setting = settingService.seleteById(1);
            String senderName = setting.getName(),senderMobile = setting.getTel();

            User userInfo = userService.selectById(userId);
            Order orderInfo = new Order();
            orderInfo.setOrder_sn(orderService.generateOrderNumber());
            orderInfo.setUser_id(userId);
            // 收货地址和运费
            orderInfo.setConsignee(address.getName());
            orderInfo.setMobile(address.getMobile());
            orderInfo.setProvince(address.getProvince_id());
            orderInfo.setCity(address.getCity_id());
            orderInfo.setDistrict(address.getDistrict_id());
            orderInfo.setAddress(address.getAddress());
            orderInfo.setOrder_status(101);// 订单初始状态为 101
            // 根据城市得到运费，这里需要建立表：所在城市的具体运费
            orderInfo.setFreight_price(freightPrice);
            orderInfo.setPostscript(postscript);
            orderInfo.setAdd_time(currentTime);
            orderInfo.setGoods_price(goodsTotalPrice);
            orderInfo.setOrder_price(orderTotalPrice);
            orderInfo.setActual_price((float) actualPrice);
            orderInfo.setChange_price((float) actualPrice);
            orderInfo.setPrint_info(print_info);
            orderInfo.setOffline_pay(offlinePay);

            // 开启事务，插入订单信息和订单商品
            orderService.add(orderInfo);
            Integer orderId = orderInfo.getId();
            if (orderId == null){
                return new MyResponse().errno(1).stateCode("error").message("订单提交失败");
            }

            // 将商品信息录入数据库
            List<OrderGoods> orderGoodsList = new ArrayList<>();
            for (Cart cart:cartList) {
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setUser_id(userId);
                orderGoods.setOrder_id(orderId);
                orderGoods.setGoods_id(cart.getGoods_id());
                orderGoods.setProduct_id(cart.getProduct_id());
                orderGoods.setGoods_name(cart.getGoods_name());
                orderGoods.setGoods_aka(cart.getGoods_aka());
                orderGoods.setList_pic_url(cart.getList_pic_url());
                orderGoods.setRetail_price(cart.getRetail_price());
                orderGoods.setNumber(cart.getNumber());
                orderGoods.setGoods_specifition_ids(cart.getGoods_specifition_ids());
                orderGoods.setGoods_specifition_name_value(cart.getGoods_specifition_name_value());
                orderGoodsList.add(orderGoods);
            }
            orderGoodsService.insertList(orderGoodsList);
            // 清空已购买的商品
            cartService.clearBuyGoods(userId);
            Map<String,Object> result = new HashMap<>();
            result.put("orderInfo",orderInfo);
            return new MyResponse().errno(1).stateCode("success").data(result).message("提交订单成功");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  订单列表
     * @Author liuxin
     * */
    @GetMapping(value = "order/list")
    public MyResponse getOrderList(@RequestParam Map<String,String> params){
        try {
            System.out.println(params);
            Integer showType = Integer.valueOf(params.get("showType"));
            Integer page = Integer.valueOf(params.get("page"));
            Integer size = Integer.valueOf(params.get("size"));
            Integer userId = Integer.valueOf(params.get("userId"));
            List<Order> orderList = orderService.getOrderList(userId,showType);
            Map<String,Object> result = new HashMap<>();
            result.put("count",result.size());
            result.put("data",orderList);
            return new MyResponse().errno(0).data(result).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).message("获取失败，"+e);
        }
    }


    /**
     *  订单详情order/detail
     * @Author liuxin
     * */
    @GetMapping(value = "order/detail")
    public MyResponse getOrderDetail(@RequestParam(value = "orderId") Integer orderId,
                                     @RequestParam(value = "userId") Integer userId){
        try {
            return new MyResponse().errno(0).data(orderService.getOrderDetail(orderId,userId)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).message("获取失败，"+e);
        }
    }

    /**
     *  订单删除
     * @Author liuxin
     * */
    @PostMapping("order/delete")
    public void orderDelete(@RequestBody Map<String,String> params){
        try{
            Integer orderId = Integer.valueOf(params.get("orderId"));
            orderService.orderDelete(orderId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  取消订单
     * @Author liuxin
     * */
    @PostMapping("order/cancel")
    public void orderCancel(@RequestBody Map<String,String> params){
        try{
            Integer orderId = Integer.valueOf(params.get("orderId"));
            Integer userId = Integer.valueOf(params.get("userId"));
            orderService.orderCancel(orderId,userId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  物流详情
     * @Author liuxin
     * */

    /**
     *  获取订单数 order/count
     * @Author liuxin
     * */
    @GetMapping(value = "order/count")
    public MyResponse getOrderCount(@RequestParam(value = "userId") Integer userId,
                                    @RequestParam(value = "showType") Integer showType){
        try {
            return new MyResponse().errno(0).data(orderService.getCount(showType,userId)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).message("获取失败，"+e);
        }
    }

    /**
     *  我的页面获取订单数状态 order/orderCount
     * @Author liuxin
     * */
    @GetMapping(value = "order/orderCount/{userId}")
    public MyResponse getOrderCount(@PathVariable(value = "userId") String userId){
        try {
            System.out.println(userId);
            Map<String,Integer> result = orderService.getOrderCount(Integer.valueOf(userId));
            return new MyResponse().errno(0).data(result).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).message("获取失败");
        }
    }



    /**
     *  获取checkout页面的商品列表
     * @Author liuxin
     * */


}

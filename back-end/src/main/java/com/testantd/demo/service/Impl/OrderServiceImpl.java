package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.*;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.mapper.*;
import com.testantd.demo.service.OrderService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private RegionMapper regionMapper;

    /**
     *  订单状态list生成
     * @Author liuxin
     * */
    public List<String> getOrderStatusCode(Integer showType){
        try {
            switch (showType){
                case 0:
                    return (List<String>) Arrays.asList("101", "102", "103", "201", "202", "203", "300", "301", "302", "303", "401");
                case 1:
                    return (List<String>) Arrays.asList("101", "801");
                case 2:
                    return (List<String>) Arrays.asList("300");
                case 3:
                    return (List<String>) Arrays.asList("301");
                case 4:
                    return (List<String>) Arrays.asList("302","303");
                default:
                    return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  获取订单的状态文字
     * @Author liuxin
     * */
    public String getOrderStatusText(Integer type){
        String statusText = "";
        switch (type){
            case 101:
                statusText = "待付款";
                break;
            case 102:
                statusText = "交易关闭";
                break;
            case 103:
                statusText = "交易关闭"; //到时间系统自动取消
                break;
            case 201:
                statusText = "待发货";
                break;
            case 300:
                statusText = "待发货";
                break;
            case 301:
                statusText = "已发货";
                break;
            case 401:
                statusText = "交易成功"; //到时间，未收货的系统自动收货、
                break;
        }
        return statusText;
    }

    /**
     *  获取订单的可以操作选项
     * @Author liuxin
     * */
    private OrderOperation getOrderHandleOption(Integer order_status) {
        try {
            OrderOperation orderOperation = new OrderOperation(false,false,false,false,false);
            // 订单流程：下单成功－》支付订单－》发货－》收货－》评论
            // 订单相关状态字段设计，采用单个字段表示全部的订单状态
            // 1xx表示订单取消和删除等状态：  101订单创建成功等待付款、102订单已取消、103订单已取消(自动)
            // 2xx表示订单支付状态：        201订单已付款，等待发货、202订单取消，退款中、203已退款
            // 3xx表示订单物流相关状态：     301订单已发货，302用户确认收货、303系统自动收货
            // 4xx表示订单完成的状态：      401已收货已评价
            // 5xx表示订单退换货相关的状态：  501已收货，退款退货 TODO
            // 如果订单已经取消或是已完成，则可删除和再次购买
            // if (status == 101) "未付款";
            // if (status == 102) "已取消";
            // if (status == 103) "已取消(系统)";
            // if (status == 201) "已付款";
            // if (status == 301) "已发货";
            // if (status == 302) "已收货";
            // if (status == 303) "已收货(系统)";
            //  TODO 设置一个定时器，自动将有些订单设为完成
            // 订单刚创建，可以取消订单，可以继续支付
            if (order_status == 101 || order_status == 801) {
                orderOperation.setCancel(true);
                orderOperation.setPay(true);
            }
            // 如果订单被取消
            if (order_status == 102 || order_status == 103) {
                orderOperation.setDelete(true);
            }
            // 如果订单已付款，没有发货，则可退款操作
            if (order_status == 201) {
                // handleOption.return = true;
            }
            // 如果订单申请退款中，没有相关操作
            if (order_status == 202) {
                orderOperation.setCancel_refund(true);
            }
            if (order_status == 300) {}
            // 如果订单已经退款，则可删除
            if (order_status == 203) {
                orderOperation.setDelete(true);
            }
            // 如果订单已经发货，没有收货，则可收货操作,
            // 此时不能取消订单
            if (order_status == 301) {
                orderOperation.setConfirm(true);
            }
            if (order_status == 401) {
                orderOperation.setDelete(true);
            }
            return orderOperation;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> getOrderList(Integer userId, Integer showType) {
        try{
            Integer isDelete = 0;
            List<String> statusList = getOrderStatusCode(showType);
            Example example = new Example(Order.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andCondition("user_id = ",userId);
            criteria.andCondition("is_delete = ",isDelete);
            criteria.andLessThan("order_type",7);
            criteria.andIn("order_status",statusList);
            example.setOrderByClause("add_time desc");
            List<Order> orderList = orderMapper.selectByExample(example);
            for (Order order:orderList) {
                Example example1 = new Example(OrderGoods.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andCondition("user_id = ", userId);
                criteria1.andCondition("order_id = ", order.getId());
                criteria1.andCondition("is_delete = ", 0);
                List<OrderGoods> orderGoodsList = orderGoodsMapper.selectByExample(example1);
                System.out.println(orderGoodsList);
                order.setGoodsList(orderGoodsList);
                for (OrderGoods orderGoods:orderGoodsList) {
                    System.out.println("order:"+order);
                    System.out.println("orderGoods:"+orderGoods);
                    order.setGoodsCount(order.getGoodsCount()+orderGoods.getNumber());
                }
                // 订单状态的处理
                order.setOrder_status_text(getOrderStatusText(order.getOrder_status()));
                order.setHandleOption(getOrderHandleOption(order.getOrder_status()));
            }
            return orderList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> getOrderDetail(Integer orderId, Integer userId) throws Exception {
        Order orderInfo = orderMapper.selectByPrimaryKey(orderId);
        if (orderInfo == null) {
            throw new Exception("订单不存在");
        }

        Long currentTime = new Date().getTime()/1000;
        Region province = regionMapper.selectByPrimaryKey(orderInfo.getProvince());
        Region city = regionMapper.selectByPrimaryKey(orderInfo.getCity());
        Region district = regionMapper.selectByPrimaryKey(orderInfo.getDistrict());
        String fullRegion = province.getName();
        orderInfo.setProvince_name(province.getName());
        orderInfo.setCity_name(city.getName());
        orderInfo.setDistrict_name(district.getName());
        orderInfo.setFull_region(fullRegion);

        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setUser_id(userId);
        orderGoods.setOrder_id(orderId);
        orderGoods.setIs_delete(0);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(orderGoods);
        int goodsCount = 0;
        for (OrderGoods item:orderGoodsList) {
            goodsCount += item.getNumber();
        }
        // 订单状态的处理
        orderInfo.setOrder_status_text(getOrderStatusText(orderInfo.getOrder_status()));
        if (orderInfo.getConfirm_time() == null) {
            orderInfo.setConfirm_time(0);
        }
        if (orderInfo.getDealdone_time() == null) {
            orderInfo.setDealdone_time(0);
        }
        if (orderInfo.getPay_time() == null) {
            orderInfo.setPay_time(0);
        }
        if (orderInfo.getShipping_time() == null) {
            orderInfo.setShipping_time(0);
        }

        // 订单支付倒计时
        if (orderInfo.getOrder_status() == 101 || orderInfo.getOrder_status() == 801) {
            // if (moment().subtract(60, 'minutes') < moment(orderInfo.add_time)) {
            orderInfo.setFinal_pay_time(orderInfo.getAdd_time()+24 * 60 * 60);//支付倒计时2小时
            if (orderInfo.getFinal_pay_time() < currentTime) {
                //超过时间不支付，更新订单状态为取消
                Order tempOrder = new Order();
                tempOrder.setOrder_status(102);
                tempOrder.setId(orderId);
                orderMapper.updateByPrimaryKey(tempOrder);
            }
        }
        Order currentOrder = orderMapper.selectByPrimaryKey(orderId);
        OrderOperation handleOption = getOrderHandleOption(currentOrder.getOrder_status());

        Map<String,Object> result = new HashMap<>();
        result.put("orderInfo",orderInfo);
        result.put("orderGoods",orderGoods);
        result.put("handleOption",handleOption);
        result.put("goodsCount",goodsCount);

        return result;
    }

    @Override
    public Map<String, Object> getCount(Integer showType, Integer userId) {
        try {
            List<String> statusList = this.getOrderStatusCode(showType);
            Example example = new Example(Order.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andCondition("user_id = ",userId);
            criteria.andCondition("is_delete = ",0);
            criteria.andIn("order_status",statusList);
            Map<String,Object> result = new HashMap<>();
            Integer allCount = orderMapper.selectCountByExample(example);
            result.put("allCount",allCount);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Integer> getOrderCount(Integer userId) {
        Map<String,Integer> result = new HashMap<>();
        result.put("toPay",getOrderCountByOrderStatus(userId,Arrays.asList("101","801")));
        result.put("toDelivery",getOrderCountByOrderStatus(userId,Arrays.asList("300")));
        result.put("toReceive",getOrderCountByOrderStatus(userId,Arrays.asList("301")));
        return result;
    }

    @Override
    public void orderSubmit(Integer userId, Integer addressId, Float freightPrice, Integer offlinePay, String postscript) {
        // 获取要购买的商品

    }

    @Override
    public String generateOrderNumber() {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = sdf.format(date);
        return str + (int)(100000+Math.random()*(900000));
    }

    @Override
    public Integer add(Order orderInfo) {
        return orderMapper.insertSelective(orderInfo);
    }

    @Override
    public void orderDelete(Integer orderId) throws Exception {
        // 检测是否能够取消
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderOperation orderOperation = getOrderHandleOption(order.getOrder_status());
        if (!orderOperation.getDelete()){
            throw new Exception("订单不能删除");
        }
        orderMapper.deleteByPrimaryKey(orderId);

    }

    @Override
    public void orderCancel(Integer orderId,Integer userId) throws Exception {
        // 检测是否能够取消
        Order orderInfo = orderMapper.selectByPrimaryKey(orderId);
        OrderOperation orderOperation = getOrderHandleOption(orderInfo.getOrder_status());
        if (!orderOperation.getCancel()){
            throw new Exception("订单不能取消");
        }
        //取消订单，还原库存
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setOrder_id(orderId);
        orderGoods.setUser_id(userId);
        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(orderGoods);
        for (OrderGoods item:orderGoodsList) {
            Integer goodsId = item.getGoods_id();
            Integer productId = item.getProduct_id();
            Integer number = item.getNumber();
            Good good = new Good();
            good.setId(goodsId);
            good = goodsMapper.selectOne(good);
            good.setGoods_number(good.getGoods_number()+number);
            goodsMapper.updateByPrimaryKey(good);

            Product product = new Product();
            product.setId(productId);
            product = productMapper.selectOne(product);
            product.setGoods_number(product.getGoods_number()+number);
            productMapper.updateByPrimaryKey(product);
        }
        orderInfo.setOrder_status(102);
        orderMapper.updateByPrimaryKey(orderInfo);
    }

    private Integer getOrderCountByOrderStatus(Integer userId,List<String> orderStatus){
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("user_id = ",userId);
        criteria.andCondition("is_delete = ",0);
        criteria.andCondition("order_type < ",7);
        criteria.andIn("order_status",orderStatus);
        return orderMapper.selectCountByExample(example);
    }

}

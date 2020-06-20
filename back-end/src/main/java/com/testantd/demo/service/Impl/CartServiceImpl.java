package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.*;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.mapper.*;
import com.testantd.demo.service.CartService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.annotation.Order;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private AddressMapper addressMapper;

    @Override
    public Object cartAdd(Integer goodsId, Integer productId, Integer number, Integer addType,Integer userId) throws Exception {
        Long currentTime = new Date().getTime()/1000;
        // 判断商品是否可以购买
        Good goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods == null || goods.getIs_on_sale() == 0){
            throw new Exception("商品已下架");
        }

        // 取得规格的信息,判断规格库存
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null || product.getGoods_number() < number){
            throw new Exception("库存不足");
        }

        // 判断购物车中是否存在此规格商品
        Example cartExample = new Example(Cart.class);
        Example.Criteria cartCriteria = cartExample.createCriteria();
        cartCriteria.andCondition("user_id = ",userId);
        cartCriteria.andCondition("product_id = ",productId);
        cartCriteria.andCondition("is_delete = ",0);
        Cart cartInfo = cartMapper.selectOneByExample(cartExample);

        Float retailPrice = product.getRetail_price();
        if (addType == 1){
            Example cartExample2 = new Example(Cart.class);
            Example.Criteria cartCriteria2 = cartExample2.createCriteria();
            cartCriteria2.andCondition("user_id = ",userId);
            cartCriteria2.andCondition("is_delete = ",0);
            Cart cartTemp = new Cart();
            cartTemp.setChecked(0);
            cartMapper.updateByExampleSelective(cartTemp,cartExample2);

            List<GoodsSpecification> goodsSepcifition = null;
            if (product.getGoods_specification_ids() != null){
                Example goodsSpecificationExample = new Example(GoodsSpecification.class);
                Example.Criteria goodsSpecificationCriteria = goodsSpecificationExample.createCriteria();
                goodsSpecificationCriteria.andCondition("goods_id = ",product.getGoods_id());
                goodsSpecificationCriteria.andCondition("is_delete = ",0);
                String[] idList= product.getGoods_specification_ids().split("_");
                goodsSpecificationCriteria.andIn("id", Arrays.asList(idList));
                goodsSepcifition = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
            }

            Cart cartObj = new Cart();
            cartObj.setGoods_id(product.getGoods_id());
            cartObj.setProduct_id(productId);
            cartObj.setGoods_sn(product.getGoods_sn());
            cartObj.setGoods_name(goods.getName());
            cartObj.setGoods_aka(product.getGoods_name());
            cartObj.setGoods_weight(product.getGoods_weight());
            cartObj.setFreight_template_id(goods.getFreight_template_id());
            cartObj.setList_pic_url(goods.getList_pic_url());
            cartObj.setNumber(number);
            cartObj.setUser_id(userId);
            cartObj.setRetail_price(retailPrice);
            cartObj.setAdd_price(retailPrice);
            cartObj.setGoods_specifition_name_value(getGoodsSepcifitionValue(goodsSepcifition));
            cartObj.setGoods_specifition_ids(product.getGoods_specification_ids());
            cartObj.setChecked(1);
            cartObj.setAdd_time(currentTime);
            cartObj.setIs_fast(1);
            cartMapper.insertSelective(cartObj);
            return this.getCart(1,userId);
            
        }else{
            if (cartInfo == null){
                // 添加操作
                // 添加规格名和值
                List<GoodsSpecification> goodsSepcifition = null;
                if (product.getGoods_specification_ids() != null){
                    Example goodsSpecificationExample = new Example(GoodsSpecification.class);
                    Example.Criteria goodsSpecificationCriteria = goodsSpecificationExample.createCriteria();
                    goodsSpecificationCriteria.andCondition("goods_id = ",product.getGoods_id());
                    goodsSpecificationCriteria.andCondition("is_delete = ",0);
                    String[] idList= product.getGoods_specification_ids().split("_");
                    goodsSpecificationCriteria.andIn("id", Arrays.asList(idList));
                    goodsSepcifition = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
                }
                // 添加到购物车
                Cart cartObj = new Cart();
                cartObj.setGoods_id(product.getGoods_id());
                cartObj.setProduct_id(productId);
                cartObj.setGoods_sn(product.getGoods_sn());
                cartObj.setGoods_name(goods.getName());
                cartObj.setGoods_aka(product.getGoods_name());
                cartObj.setGoods_weight(product.getGoods_weight());
                cartObj.setFreight_template_id(goods.getFreight_template_id());
                cartObj.setList_pic_url(goods.getList_pic_url());
                cartObj.setNumber(number);
                cartObj.setUser_id(userId);
                cartObj.setRetail_price(retailPrice);
                cartObj.setAdd_price(retailPrice);
                cartObj.setGoods_specifition_name_value(getGoodsSepcifitionValue(goodsSepcifition));
                cartObj.setGoods_specifition_ids(product.getGoods_specification_ids());
                cartObj.setChecked(1);
                cartObj.setAdd_time(currentTime);
                cartObj.setIs_fast(0);
                cartMapper.insertSelective(cartObj);
            }else{
                // 如果已经存在购物车中，则数量增加
                if (product.getGoods_number() < ( number + cartInfo.getNumber())) {
                    return new Exception("库存都不够啦");
                }
                Example exampleEnd = new Example(Cart.class);
                Example.Criteria criteriaEnd = exampleEnd.createCriteria();
                criteriaEnd.andCondition("user_id = ",userId);
                criteriaEnd.andCondition("product_id = ",productId);
                criteriaEnd.andCondition("is_delete = ",0);
                criteriaEnd.andCondition("id = ", cartInfo.getId());
                Cart cart = new Cart();
                cart.setRetail_price(retailPrice);
                cart.setNumber(cartInfo.getNumber() + number);
                cartMapper.updateByExampleSelective(cart,exampleEnd);

            }
            return this.getCart(0,userId);
        }
    }

    public Map<String,Object> getCart(Integer type,Integer userId){
        try{
            Example queryExample = new Example(Cart.class);
            Example.Criteria queryExampleCriteria = queryExample.createCriteria();
            queryExampleCriteria.andCondition("user_id = ", userId);
            queryExampleCriteria.andCondition("is_delete = ", 0);
            if (type == 0){
                queryExampleCriteria.andCondition("is_fast = ",0);
            }else{
                queryExampleCriteria.andCondition("is_fast = ",1);
            }
            List<Cart> cartList = cartMapper.selectByExample(queryExample);
            // 获取购物车统计信息
            Integer goodsCount = 0;
            Float goodsAmount = new Float(0);
            Integer checkedGoodsCount = 0;
            Float checkedGoodsAmount = new Float(0);
            Integer numberChange = 0;
            for (Cart item:cartList) {
                Product queryProduct = new Product();
                queryProduct.setId(item.getProduct_id());
                queryProduct.setIs_delete(0);
                Product product = productMapper.selectOne(queryProduct);
                if (product == null){
                    Example example = new Example(Cart.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andCondition("product_id = ",item.getProduct_id());
                    criteria.andCondition("user_id = ",userId);
                    criteria.andCondition("is_delete = ", 0);
                    Cart updateCart = new Cart();
                    updateCart.setIs_delete(1);
                    cartMapper.updateByExampleSelective(updateCart,example);
                }else{
                    Float retailPrice = product.getRetail_price();
                    Integer productNum = product.getGoods_number();
                    if (productNum <= 0 || product.getIs_on_sale() == 0){
                        Example cartExample = new Example(Cart.class);
                        Example.Criteria cartCritaria = cartExample.createCriteria();
                        cartCritaria.andCondition("product_id = ",item.getProduct_id());
                        cartCritaria.andCondition("user_id = ",userId);
                        cartCritaria.andCondition("checked = ",1);
                        cartCritaria.andCondition("is_delete = ",0);
                        Cart updatecart2 = new Cart();
                        updatecart2.setChecked(0);
                        cartMapper.updateByExampleSelective(updatecart2,cartExample);
                        item.setNumber(0);
                    }else if(productNum > 0 && productNum < item.getNumber()){
                        item.setNumber(productNum);
                        numberChange = 1;
                    }else if (productNum > 0 && item.getNumber() == 0) {
                        item.setNumber(1);
                        numberChange = 1;
                    }
                    goodsCount += item.getNumber();
                    goodsAmount += item.getNumber() * retailPrice;
                    item.setRetail_price(retailPrice);
                    if (item.getChecked() == 1 && productNum > 0){
                        checkedGoodsCount += item.getNumber();
                        checkedGoodsAmount += item.getNumber() * Float.valueOf((retailPrice));
                    }

                    // 查找商品的图片
                    Good goodInfo = goodsMapper.selectByPrimaryKey(item.getGoods_id());
                    item.setList_pic_url(goodInfo.getList_pic_url());
                    item.setWeight_count((float) (item.getNumber() * item.getGoods_weight()));
                    Example updateCartExample3 = new Example(Cart.class);
                    Example.Criteria updateCartCriteria3 = updateCartExample3.createCriteria();
                    updateCartCriteria3.andCondition("product_id = ",item.getProduct_id());
                    updateCartCriteria3.andCondition("user_id = ",userId);
                    updateCartCriteria3.andCondition("is_delete = ",0);
                    Cart updateCard = new Cart();
                    updateCard.setNumber(item.getNumber());
                    updateCard.setAdd_price(retailPrice);
                    cartMapper.updateByExampleSelective(updateCard,updateCartExample3);
                }
            }
            Float cAmount = checkedGoodsAmount;
            Float aAmount = checkedGoodsAmount;

            Map<String,Object> result = new HashMap<>();
            result.put("cartList",cartList);
            Map<String,Object> cartTotal = new HashMap<>();
            cartTotal.put("goodsCount",goodsCount);
            cartTotal.put("goodsAmount",goodsAmount);
            cartTotal.put("checkedGoodsCount",checkedGoodsCount);
            cartTotal.put("checkedGoodsAmount",cAmount);
            cartTotal.put("user_id",userId);
            cartTotal.put("numberChange",numberChange);
            result.put("cartTotal",cartTotal);
            Map<String,Object> endResult = new HashMap<>();
            endResult.put("data",result);
            endResult.put("errno",0);
            return endResult;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteFast(Integer userId) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("user_id = ",userId);
        criteria.andCondition("is_delete = ",0);
        criteria.andCondition("is_fast = ",1);
        Cart cart = new Cart();
        cart.setIs_delete(1);
        cartMapper.updateByExampleSelective(cart,example);
    }

    @Override
    public Map<String, Object> updateCart(Integer id, Integer number, Integer productId,Integer userId) throws Exception {
        try{
            // 取得规格的信息,判断规格库存
            Example example1 = new Example(Product.class);
            Example.Criteria criteria = example1.createCriteria();
            criteria.andCondition("id = ",productId);
            criteria.andCondition("is_delete = ",0);

            Product product = productMapper.selectOneByExample(example1);
            if (product == null || product.getGoods_number() < number){
                throw new Exception("库存不足");
            }
            // 判断是否已经存在product_id购物车商品
            Example example2 = new Example(Cart.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andCondition("id = ",id);
            criteria2.andCondition("is_delete = ",0);
            Cart cart = cartMapper.selectOneByExample(example2);
            // 只是更新number
            if (cart.getProduct_id().equals(productId)){
                cart.setNumber(number);
                cartMapper.updateByExampleSelective(cart,example2);
            }
            return this.getCart(0,userId);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Map<String,Object> cartChecked(String productIds, String isChecked, Integer userId) {
        String[] productIdList = productIds.split(",");
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("user_id = ", userId);
        criteria.andCondition("is_delete = ",0);
        criteria.andIn("product_id", Arrays.asList(productIdList));
        Cart cart = new Cart();
        cart.setChecked(Integer.valueOf(isChecked));
        cartMapper.updateByExampleSelective(cart,example);
        return this.getCart(0,userId);
    }

    @Override
    public Map<String, Object> cartDelete(String productIds, Integer userId) {
        String[] productIdList = productIds.split(",");
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("user_id = ", userId);
        criteria.andCondition("is_delete = ",0);
        criteria.andIn("product_id", Arrays.asList(productIdList));
        Cart cart = new Cart();
        cart.setIs_delete(1);
        cartMapper.updateByExampleSelective(cart,example);
        return this.getCart(0,userId);
    }

    @Override
    public Object cartCheckout(Integer orderFrom, Integer type, Integer addressId, Integer addType, Integer userId) {
        Integer goodsCount = 0; // 购物车的数量
        Float goodsMoney = new Float(0); // 购物车的总价
        Integer freightPrice = 0;
        Integer outStock = 0;
        Map<String,Object> cartData = null;
        // 获取要购买的商品
        if (type == 0){
            if (addType == 0){
                cartData = this.getCart(0,userId);
            }else if (addType == 1){
                cartData = this.getCart(1,userId);
            }else if (addType == 2){
//                cartData = this.getAgainCart(orderFrom,userId);
            }
        }
        System.out.println(cartData);
        List<Cart> cartList = new ArrayList<>();
        List<Cart> cartList1 = (List<Cart>) ((Map<String,Object>)cartData.get("data")).get("cartList");
        System.out.println(cartList1);
        for (Cart cart:cartList1) {
            if (cart.getChecked() == 1){
                cartList.add(cart);
                goodsCount = goodsCount + cart.getNumber();
                goodsMoney = goodsMoney + cart.getNumber() * cart.getRetail_price();
                // 这里可能有问题
                if (cart.getNumber() <= 0 || cart.getIs_on_sale() == 0) {
                    outStock = (outStock) + 1;
                }
            }
        }
        if (addType == 2) {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrder_id(orderFrom);
            List<OrderGoods> againGoods = orderGoodsMapper.select(orderGoods);
            Integer againGoodsCount = 0;
            for (OrderGoods item:againGoods ) {
                againGoodsCount +=  item.getNumber();
            }
            if (goodsCount != againGoodsCount){
                outStock = 1;
            }

        }
        // 选择的收货地址
        Address checkedAddress = null;
        if (addressId == null || addressId == 0){
            checkedAddress = addressMapper.selectDefaultAddress(userId);
        }else{
            Address address = new Address();
            address.setId(addressId);
            address.setUser_id(userId);
            address.setIs_delete(0);
            checkedAddress = addressMapper.selectAddressById(addressId,userId);
        }

        // 计算订单费用
        Map<String,Object> cartTotal = (Map<String, Object>) ((Map<String, Object>) cartData.get("data")).get("cartTotal");
        System.out.println(cartTotal);
        float goodsTotalPrice = (float) (cartTotal.get("checkedGoodsAmount"));
        float orderTotalPrice = goodsTotalPrice;
        float actualPrice = orderTotalPrice;
        int numberChange = (int) cartTotal.get("numberChange");

        Map<String,Object> result = new HashMap<>();
        result.put("checkedAddress",checkedAddress);
        result.put("freightPrice",0);
        result.put("checkedGoodsList",cartList);
        result.put("goodsTotalPrice",goodsTotalPrice);
        result.put("orderTotalPrice",orderTotalPrice);
        result.put("actualPrice",actualPrice);
        result.put("goodsCount",goodsCount);
        result.put("outStock",outStock);
        result.put("numberChange",numberChange);

        return result;
    }

    @Override
    public List<Cart> getCartSelected(Integer userId) {
        Cart cart = new Cart();
        cart.setUser_id(userId);
        cart.setChecked(1);
        cart.setIs_delete(0);
        return cartMapper.select(cart);
    }

    @Override
    public void clearBuyGoods(Integer userId) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("user_id = ",userId);
        criteria.andCondition("checked = ",1);
        criteria.andCondition("is_delete = ",0);

        Cart cart = new Cart();
        cart.setIs_delete(1);
        cartMapper.updateByExampleSelective(cart,example);
    }

    private String getGoodsSepcifitionValue(List<GoodsSpecification> goodsSepcifition){
        try{
             String result = "";
            for (GoodsSpecification obj:goodsSepcifition) {
                result += obj.getValue() + ";";
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package com.testantd.demo.service;

import com.testantd.demo.bean.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
    Object cartAdd(Integer goodsId, Integer productId, Integer number, Integer addType,Integer userId) throws Exception;

    Map<String,Object> getCart(Integer type,Integer userId);

    void deleteFast(Integer userId);

    Map<String,Object> updateCart(Integer id, Integer number, Integer productId,Integer userId) throws Exception;

    Map<String,Object> cartChecked(String productIds, String isChecked, Integer userId);

    Map<String,Object> cartDelete(String productIds, Integer userId);

    Object cartCheckout(Integer orderFrom, Integer type, Integer addressId, Integer addType, Integer userId);

    List<Cart> getCartSelected(Integer userId);

    void clearBuyGoods(Integer userId);
}

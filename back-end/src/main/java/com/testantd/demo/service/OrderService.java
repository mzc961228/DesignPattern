package com.testantd.demo.service;

import com.testantd.demo.bean.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<String> getOrderStatusCode(Integer showType);

    List<Order> getOrderList(Integer userId, Integer showType);

    Map<String,Object> getOrderDetail(Integer orderId,Integer userId) throws Exception;

    Map<String, Object> getCount(Integer showType, Integer userId);

    Map<String, Integer> getOrderCount(Integer userId);

    void orderSubmit(Integer userId, Integer addressId, Float freightPrice, Integer offlinePay, String postscript);

    String generateOrderNumber();

    Integer add(Order orderInfo);

    void orderDelete(Integer orderId) throws Exception;

    void orderCancel(Integer orderId,Integer userId) throws Exception;
}

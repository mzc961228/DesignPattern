package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.OrderGoods;
import com.testantd.demo.mapper.OrderGoodsMapper;
import com.testantd.demo.service.OrderGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    public void insertList(List<OrderGoods> orderGoodsList) {
        for (OrderGoods orderGoods:orderGoodsList) {
            orderGoodsMapper.insertSelective(orderGoods);
        }
    }
}

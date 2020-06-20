package com.testantd.demo.service;

import com.testantd.demo.bean.Good;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    List<Good> getGoods(Integer page, Integer size);

    List<Good> getGoodsByCategory(Integer categoryId);

    Integer getCount();

    Map<String,Object> getDetail(Integer id) throws Exception;

    List<Good> getGoodsList(String keyword, String sort, String order, String sales);

    Good getGoodsById(Integer id);
}

package com.testantd.demo.service;

import com.testantd.demo.bean.Category;

import java.util.List;

public interface CategoryService {

    /* 分类目录全部分类数据接口 */
    public List<Category> getCategoryIndex();

    /* 首页获取目录 */
    public List<Category> selectCategoryListWithGoods();

    public List<Category> getChannelList();

    /* 分类目录当前分类数据接口 */
    public Category getCategoryCurrent(Integer catalogId);
}

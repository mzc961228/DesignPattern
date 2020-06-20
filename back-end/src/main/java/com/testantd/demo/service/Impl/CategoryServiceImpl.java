package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Category;
import com.testantd.demo.mapper.CategoryMapper;
import com.testantd.demo.service.CategoryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryIndex() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("parent_id = ", 0);
        criteria.andCondition("is_category = ",1);
        example.setOrderByClause("sort_order asc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> selectCategoryListWithGoods() {
        return categoryMapper.selectCategoryListWithGoods();
    }

    @Override
    public List<Category> getChannelList() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("parent_id = ", 0);
        criteria.andCondition("is_channel = ",1);
        example.setOrderByClause("sort_order asc");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category getCategoryCurrent(Integer catalogId) {
        return categoryMapper.selectByPrimaryKey(catalogId);
    }
}

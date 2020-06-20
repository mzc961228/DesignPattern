package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Product;
import com.testantd.demo.mapper.ProductMapper;
import com.testantd.demo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public Product selectById(Integer product_id) {
        return productMapper.selectByPrimaryKey(product_id);
    }
}

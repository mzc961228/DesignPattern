package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.*;
import com.testantd.demo.mapper.*;
import com.testantd.demo.service.GoodsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GalleryMapper galleryMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Resource
    private SpecificationMapper specificationMapper;

    @Override
    public List<Good> getGoods(Integer page, Integer size) {
        Example example = new Example(Good.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("is_on_sale = ", 1);
        criteria.andCondition("is_delete = ",0);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<Good> getGoodsByCategory(Integer categoryId) {
        Example example = new Example(Good.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("category_id = ",categoryId);
        criteria.andCondition("is_on_sale = ", 1);
        criteria.andCondition("is_delete = ",0);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Integer getCount() {
        return goodsMapper.selectAll().size();
    }

    @Override
    public Map<String, Object> getDetail(Integer id) throws Exception {
        try {
            Map<String,Object> result = new HashMap<>();
            /* 获取物品的信息 */
            Example goodsExample = new Example(Good.class);
            Example.Criteria goodsCriteria = goodsExample.createCriteria();
            goodsCriteria.andCondition("id = ",id);
            goodsCriteria.andCondition("is_delete = ",0);
            Good goodInfo = goodsMapper.selectOneByExample(goodsExample);
            if (goodInfo == null){
                throw new Exception("该商品不存在或已下架");
            }


            /* 获取物品的gallery */
            Example galleryExample = new Example(Gallery.class);
            Example.Criteria galleryCriteria = galleryExample.createCriteria();
            galleryCriteria.andCondition("goods_id = ",id);
            galleryCriteria.andCondition("is_delete = ",0);
            List<Gallery> gallery = galleryMapper.selectByExample(galleryExample);
            result.put("gallery",gallery);

            /* 获取product */
            Example productExample = new Example(Product.class);
            Example.Criteria productCriteria = productExample.createCriteria();
            productCriteria.andCondition("goods_id = ",id);
            productCriteria.andCondition("is_delete = ",0);
            List<Product> productList = productMapper.selectByExample(productExample);
            result.put("gallery",gallery);

            int goodsNumber = 0;
            for (Product product:productList) {
                goodsNumber += product.getGoods_number();
            }
            goodInfo.setGoods_number(goodsNumber);
            result.put("info",goodInfo);

            /* 获取specification */
            Example goodsSpecificationExample = new Example(GoodsSpecification.class);
            Example.Criteria goodsSpecificationCriteria = goodsSpecificationExample.createCriteria();
            goodsSpecificationCriteria.andCondition("goods_id = ",id);
            goodsSpecificationCriteria.andCondition("is_delete = ",0);
            List<GoodsSpecification> specifications = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
            for (GoodsSpecification specification:specifications) {
                Example productExample2 = new Example(Product.class);
                Example.Criteria productCriteria2 = productExample2.createCriteria();
                System.out.println(specification.getId());
                productCriteria2.andCondition("goods_specification_ids = ",specification.getId());
                productCriteria2.andCondition("is_delete = ",0);
                Product product = productMapper.selectOneByExample(productExample2);
                specification.setGoods_number(product.getGoods_number());
            }
            Integer specId = specifications.get(0).getSpecification_id();
            System.out.println(specId);
            Example specificationExample = new Example(Specification.class);
            Example.Criteria specificationCriteria = specificationExample.createCriteria();
            specificationCriteria.andCondition("id = ",specId);
            Specification specificationObj = specificationMapper.selectOneByExample(specificationExample);
            System.out.println(specificationObj);
            String name = specificationObj.getName();
            Map<String,Object> tempResult = new HashMap<>();
            tempResult.put("specification_id",specId);
            tempResult.put("name",name);
            tempResult.put("valueList",specifications);
            result.put("specificationList",tempResult);
            result.put("productList",productList);
            result.put("message","获取详情成功");
            return result;
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<Good> getGoodsList(String keyword, String sort, String order, String sales) {
        Example example = new Example(Good.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%"+keyword+"%");
        criteria.andCondition("is_on_sale = ",1);
        criteria.andCondition("is_delete = ",0);
        if (sort.equals("price")){
            example.setOrderByClause("retail_price " +order);
        }else if (sort.equals("sales")){
            example.setOrderByClause("sell_volume " +sales);
        }else {
            example.setOrderByClause("sort_order asc");
        }
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Good getGoodsById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}

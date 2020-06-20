package com.testantd.demo.mapper;

import com.testantd.demo.bean.Category;
import com.testantd.demo.common.mapper.MyMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CategoryMapper extends MyMapper<Category> {

    @Select("select *,img_url as banner,p_height as height from hiolabs_category where parent_id = 0 and is_show = 1")
    @Results({
            @Result(property = "banner",column = "img_url"),
            @Result(property = "height",column = "p_height"),
            @Result(property="goodsList",column="id",many=@Many(select="com.testantd.demo.mapper.GoodsMapper.selectByCategoryId"))
    })
    List<Category> selectCategoryListWithGoods();
}

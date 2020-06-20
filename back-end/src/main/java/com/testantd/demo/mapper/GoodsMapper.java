package com.testantd.demo.mapper;

import com.testantd.demo.bean.Good;
import com.testantd.demo.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GoodsMapper extends MyMapper<Good> {

    @Select("select * from hiolabs_goods where category_id=#{categoryId} and goods_number >= 0 and is_on_sale = 1 and is_index = 1 and is_delete = 0 order by sort_order asc")
    List<Good> selectByCategoryId(Integer categoryId);
}

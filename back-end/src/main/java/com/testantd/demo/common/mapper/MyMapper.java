package com.testantd.demo.common.mapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: 公用Mapper接口
 * @Date: 2020/06/13 10:13
 * @Author: liuxin
 */
public interface MyMapper<T>  extends Mapper<T>,MySqlMapper<T>{

}

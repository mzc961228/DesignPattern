package com.testantd.demo.mapper;

import com.testantd.demo.bean.Banner;
import com.testantd.demo.common.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BannerMapper extends MyMapper<Banner> {

}

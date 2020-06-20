package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Banner;
import com.testantd.demo.mapper.BannerMapper;
import com.testantd.demo.service.BannerService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "bannerServiceImpl")
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getBannerList() {
        Example example = new Example(Banner.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("enabled = ", 1);
        criteria.andCondition("is_delete = ",0);
        example.setOrderByClause("sort_order asc");
        return bannerMapper.selectByExample(example);
    }
}

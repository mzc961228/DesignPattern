package com.testantd.demo.service;

import com.testantd.demo.bean.Banner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BannerService {

    public List<Banner> getBannerList();
}

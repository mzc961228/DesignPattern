package com.testantd.demo.service;

import com.testantd.demo.bean.Region;

import java.util.List;

public interface RegionService {
    List<Region> getRegionList(Integer parentId);
}

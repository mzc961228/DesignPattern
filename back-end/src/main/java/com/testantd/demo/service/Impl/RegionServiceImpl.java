package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Region;
import com.testantd.demo.mapper.RegionMapper;
import com.testantd.demo.service.RegionService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("regionService")
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<Region> getRegionList(Integer parentId) {
        Example example = new Example(Region.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("parent_id = ",parentId);
        return regionMapper.selectByExample(example);
    }
}

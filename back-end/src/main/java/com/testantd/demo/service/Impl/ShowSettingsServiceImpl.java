package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.ShowSettings;
import com.testantd.demo.mapper.ShowSettingsMapper;
import com.testantd.demo.service.ShowSettingsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("showSettingsService")
public class ShowSettingsServiceImpl implements ShowSettingsService {

    @Resource
    private ShowSettingsMapper showSettingsMapper;

    @Override
    public ShowSettings seleteById(int i) {
        return showSettingsMapper.selectByPrimaryKey(i);
    }
}

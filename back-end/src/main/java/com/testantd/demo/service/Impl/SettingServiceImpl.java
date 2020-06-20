package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Setting;
import com.testantd.demo.mapper.SettingMapper;
import com.testantd.demo.service.SettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("settingService")
public class SettingServiceImpl implements SettingService {

    @Resource
    private SettingMapper settingMapper;

    @Override
    public Setting seleteById(int i) {
        return settingMapper.selectByPrimaryKey(i);
    }
}

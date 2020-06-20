package com.testantd.demo.controller;

import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.ShowSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class SettingController {
    @Autowired
    private ShowSettingsService showSettingsService;

    /* 显示设置 */
    @GetMapping(value = "settings/showSettings")
    public MyResponse showSettings(){
        try{
            return new MyResponse().errno(0).stateCode("success").data(showSettingsService.seleteById(1));
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message("获取失败");
        }
    }
}

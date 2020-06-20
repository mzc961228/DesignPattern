package com.testantd.demo.controller;

import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/")
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     *  获取区域列表
     *  region/list
     * @Author liuxin
     * */
    @GetMapping(value = "region/list")
    public MyResponse getRegionList(@RequestParam(value = "parentId") Integer parentId){
        try{
            return new MyResponse().errno(0).stateCode("success").data(regionService.getRegionList(parentId)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }


}

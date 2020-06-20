package com.testantd.demo.controller;

import com.testantd.demo.bean.Banner;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.mapper.BannerMapper;
import com.testantd.demo.mapper.CategoryMapper;
import com.testantd.demo.mapper.GoodsMapper;
import com.testantd.demo.service.BannerService;
import com.testantd.demo.service.CategoryService;
import com.testantd.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/index/")
public class IndexController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NoticeService noticeService;

    @Resource
    private GoodsMapper goodsMapper;

    @GetMapping(value = "appInfo")
    public MyResponse getIndex(){
        try{
            Map<String,Object> result = new HashMap<>();

            /* 获取banner部分数据 */
            result.put("banner",bannerService.getBannerList());

            /* 获取分类列表部分数据（带有goodslist） */
            result.put("categoryList",categoryService.selectCategoryListWithGoods());

            /* 获取channel部分数据 */
            result.put("channel",categoryService.getChannelList());

            /* notice部分数据 */
            result.put("notice",noticeService.getNoticeList());

            return new MyResponse().data(result).stateCode("success").errno(0);
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().stateCode("error");
        }
    }
}

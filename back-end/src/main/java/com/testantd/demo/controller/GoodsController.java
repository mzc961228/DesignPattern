package com.testantd.demo.controller;

import com.testantd.demo.bean.Good;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     *  统计商品总数
     * @Author liuxin
     * */
    @GetMapping(value = "goods/count")
    public MyResponse getGoodsCount(){
        try{
            return new MyResponse().errno(0).stateCode("success").data(goodsService.getCount());
        }catch (Exception e){
            return new MyResponse().errno(1).stateCode("error").message("获取失败");
        }
    }

    @GetMapping(value = "goods/detail")
    public MyResponse getGoodsDetail(@RequestParam(value = "id") Integer id){
        try{
            Map<String,Object> result = goodsService.getDetail(id);
            return new MyResponse().errno(0).stateCode("success").data(result).message(result.get("message").toString());
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

    /**
     *  获得商品列表
     * @Author liuxin
     * */
    @GetMapping(value = "goods/list")
    public MyResponse getGoodsList(@RequestParam Map<String,String> params){
        try{
            String keyword = params.get("keyword");
            String sort = params.get("sort");
            String order = params.get("order");
            String sales = params.get("sales");
            List<Good> result = goodsService.getGoodsList(keyword,sort,order,sales);
            return new MyResponse().errno(0).stateCode("success").data(result).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

    /*
    *  获得商品的详情
    *  @Author liuxin
    * */
    @GetMapping(value = "goods/goodsShare")
    public MyResponse getGoodsShare(@RequestParam(value = "id") Integer id){
        try{
            return new MyResponse().errno(0).stateCode("success").data(goodsService.getGoodsById(id)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }
}

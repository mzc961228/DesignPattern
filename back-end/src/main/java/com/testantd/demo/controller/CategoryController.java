package com.testantd.demo.controller;

import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.CategoryService;
import com.testantd.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    /* 分类目录全部分类数据接口 */
    @GetMapping(value = "catalog/index")
    public MyResponse getCategoryIndex(){
        try{
            Map<String,Object> result = new HashMap<>();
            result.put("categoryList",categoryService.getCategoryIndex());
            return new MyResponse().errno(0).stateCode("success").data(result);
        }catch (Exception e){
            return new MyResponse().errno(1).stateCode("error").message("获取失败");
        }
    }

    /* 分类目录当前分类数据接口catalog/current */
    @GetMapping(value = "catalog/current")
    public MyResponse getCategoryCurrent(@RequestParam(value = "id") Integer catalogId){
        try{
            return new MyResponse().errno(0).stateCode("success").data(categoryService.getCategoryCurrent(catalogId));
        }catch (Exception e){
            return new MyResponse().errno(1).stateCode("error").message("获取失败");
        }
    }

    /* catalog/currentlist */
    @PostMapping(value = "catalog/currentlist")
    public MyResponse getCategoryCurrentList(@RequestBody Map<String,Integer> params){
        try{
            Integer page = params.get("page");
            Integer size = params.get("size");
            Integer categoryId = params.get("id");
            Map<String,Object> result = new HashMap<>();
            result.put("currentPage",page);
            result.put("pageSize",size);
            if (categoryId == 0){
                result.put("data",goodsService.getGoods(page,size));
                return new MyResponse().errno(0).stateCode("success").data(result);
            }else{
                result.put("data",goodsService.getGoodsByCategory(categoryId));
                return new MyResponse().errno(0).stateCode("success").data(result);
            }
        }catch (Exception e){
            return new MyResponse().errno(1).stateCode("error").message("获取失败");
        }
    }

}

package com.testantd.demo.controller;

import com.testantd.demo.bean.Cart;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@RestController
@RequestMapping(value = "api/")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     *  添加商品到购物车
     * @Author liuxin
     * */
    @PostMapping(value = "cart/add")
    public Object cartAdd(@RequestBody Map<String,String> params){
        try{
            Integer goodsId = Integer.valueOf(params.get("goodsId"));
            Integer productId = Integer.valueOf(params.get("productId"));
            Integer number = Integer.valueOf(params.get("number"));
            Integer addType = Integer.valueOf(params.get("addType"));
            Integer userId = Integer.valueOf(params.get("userId"));
//            Long currentTime = new Date().getTime()/1000;
            return cartService.cartAdd(goodsId,productId,number,addType,userId);

        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }

    /**
     *  获取购物车的数据
     * @Author liuxin
     * */
    @GetMapping(value = "cart/index/{userId}")
    public Object cartIndex(@PathVariable(value = "userId") Integer userId){
        try {
            return cartService.getCart(0,userId);
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }

    /**
     *  获取购物车商品件数
     * @Author liuxin
     * */
    @GetMapping(value = "cart/goodsCount/{userId}")
    public Object cartGoodsCount(@PathVariable(value = "userId") Integer userId){
        try {
            Map<String,Object> result = cartService.getCart(0,userId);
            System.out.println(result);
            cartService.deleteFast(userId);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }

    /**
     *  更新指定的购物车信息
     * @Author liuxin
     * */
    @PostMapping(value = "cart/update")
    public Object cartGoodsCount(@RequestBody Map<String,Integer> params){
        try {
            Integer id = params.get("id");
            Integer number = params.get("number");
            Integer productId = params.get("productId");
            Integer userId = params.get("userId");
            return cartService.updateCart(id,number,productId,userId);
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }

    /**
     *  选择或取消选择商品
     * @Author liuxin
     * */
    @PostMapping(value = "cart/checked")
    public Object cartChecked(@RequestBody Map<String,String> params){
        try {
            String productIds = params.get("productIds");
            String isChecked = params.get("isChecked");
            Integer userId = Integer.valueOf(params.get("userId"));
            return cartService.cartChecked(productIds,isChecked,userId);
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }


    /**
     *  删除购物车
     * @Author liuxin
     * */
    @PostMapping(value = "cart/delete")
    public Object cartDelete(@RequestBody Map<String,String> params){
        try {
            String productIds = params.get("productIds");
            Integer userId = Integer.valueOf(params.get("userId"));
            return cartService.cartDelete(productIds,userId);
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }

    /**
     *  下单前信息确认cart/checkout
     * */
    @GetMapping(value = "cart/checkout")
    public MyResponse cartCheckout(@RequestParam Map<String,String> params){
        try {
            Integer orderFrom = 0;
            if (!params.get("orderFrom").equals("undefined")){
                orderFrom = Integer.valueOf(params.get("orderFrom"));
            }
            Integer type = Integer.valueOf(params.get("type")); // 是否团购
            Integer addressId = Integer.valueOf(params.get("addressId"));// 收货地址id
            Integer addType = Integer.valueOf(params.get("addType"));
            Integer userId = Integer.valueOf(params.get("userId"));
            return new MyResponse().errno(0).data(cartService.cartCheckout(orderFrom,type,addressId,addType,userId)).message("确认成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).message("确认失败");

        }
    }

}

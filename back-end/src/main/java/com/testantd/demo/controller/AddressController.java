package com.testantd.demo.controller;

import com.testantd.demo.bean.Address;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     *  收货地址详情
     * @Author liuxin
     * */
    @GetMapping(value = "address/addressDetail")
    public MyResponse getAddressDetail(@RequestParam Map<String,String> params){
        try{
            Integer id = Integer.valueOf(params.get("id"));
            Integer userId = Integer.valueOf(params.get("userId"));
            return new MyResponse().errno(0).stateCode("success").data(addressService.getAddressById(id,userId)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

    /**
     *  保存收货地址
     * @Author liuxin
     * */
    @PostMapping(value = "address/saveAddress")
    public MyResponse saveAddress(@RequestBody Address address){
        try{
            return new MyResponse().errno(0).stateCode("success").data(addressService.saveAddress(address)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

    /**
     *  获取收货地址列表
     * @Author liuxin
     * */
    @GetMapping(value = "address/getAddresses/{userId}")
    public MyResponse getAddresses(@PathVariable(value = "userId") Integer userId){
        try{
            return new MyResponse().errno(0).stateCode("success").data(addressService.getAddressesByUserId(userId)).message("获取成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

    /**
     *  删除收货地址
     * @Author liuxin
     * */
    @PostMapping(value = "address/deleteAddress")
    public MyResponse deleteAddress(@RequestBody Map<String,Integer> params){
        try{
            Integer id = params.get("id");
            Integer userId = params.get("userId");
            addressService.deleteAddress(id,userId);
            return new MyResponse().errno(0).stateCode("success").message("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().errno(1).stateCode("error").message(e.getMessage());
        }
    }

}

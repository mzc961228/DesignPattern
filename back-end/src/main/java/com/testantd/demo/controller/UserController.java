package com.testantd.demo.controller;

import com.sun.javafx.collections.MappingChange;
import com.testantd.demo.bean.User;
import com.testantd.demo.common.entity.MyResponse;
import com.testantd.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.testantd.demo.common.utils.HttpClientHelper.sendGet;

@RestController
@RequestMapping(value = "/api/")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping(value = "auth/loginByWeixin")
    public MyResponse login(@RequestBody Map<String,Object> params){
        try{
//            Example example = new Example(User.class);
//            Example.Criteria criteria = example.createCriteria();
//            criteria.andCondition("wx_openid = ","oLMM44ziprsoWKC06U0PwQqHdyIc");
            User user = new User();
            user.setWeixin_openid("oLMM442YJf3E_-1O_Cq1NBz_h7iE");
            User userInfo = userMapper.selectOne(user);
            Map<String,Object> result = new HashMap<>();
            result.put("userInfo",userInfo);
            result.put("token","test123");
            result.put("is_new","0");
            return new MyResponse().stateCode("success").data(result);
        }catch (Exception e){
            e.printStackTrace();
            return new MyResponse().stateCode("error").message("登录失败，失败原因："+e);
        }
    }

    @GetMapping(value = "user")
    public MyResponse getUserList(){
        return new MyResponse().data(userMapper.selectAll());
    }

    @GetMapping(value = "user/{userId}")
    public MyResponse getUser(@PathVariable(value = "userId") Integer userId){
        User user = new User();
        user.setId(userId);
        return new MyResponse().data(userMapper.selectCountByExample(user));
    }

    @PostMapping(value = "user")
    public MyResponse createUser(@RequestBody User user){
        return new MyResponse().data(userMapper.insertSelective(user));
    }

    @DeleteMapping(value = "user/{userId}")
    public MyResponse deleteUser(@PathVariable(value = "userId") Integer userId){
        return new MyResponse().data(userMapper.deleteByPrimaryKey(userId));
    }



}

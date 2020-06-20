package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.User;
import com.testantd.demo.mapper.UserMapper;
import com.testantd.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}

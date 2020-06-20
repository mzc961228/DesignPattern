package com.testantd.demo.service;

import com.testantd.demo.bean.User;

public interface UserService {
    User selectById(Integer userId);
}

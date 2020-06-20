package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Credit;
import com.testantd.demo.mapper.CreditMapper;
import com.testantd.demo.mapper.UserMapper;
import com.testantd.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("creditService")
public class CreditServiceImpl implements CreditService {

    @Resource
    private CreditMapper creditMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Credit> SelectByUserID(int userID) {
        return null;
    }

    @Override
    public int increaseCredits(int userID, int creditAmount, int duration, int days) {
        return 0;
    }

    @Override
    public int decreaseCredits(int userID, int requiredEcredits) {
        return 0;
    }
}

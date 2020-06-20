package com.testantd.demo.controller;

import com.testantd.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController{

    @Autowired
    private CreditService creditService;

    @GetMapping("/payEcredits")
    public int  payEcredits(int userID,int requiredEcredits) {
        //花费的时候花掉的是已经存在的credits，所以先去设计未花的credits
        return creditService.decreaseCredits(userID,requiredEcredits);
    }

    @GetMapping("/getEcreditsBySign")
    public int getEcreditsBySign(int userID,int creditAmount,int duration,int days) {
        return creditService.increaseCredits(userID,creditAmount,duration,days);
    }
    @GetMapping("/getEcreditsByShopping")
    public int getEcreditsByShopping(int userID,int creditAmount,int duration,int days){
        return creditService.increaseCredits(userID,creditAmount,duration,days);
    }
}




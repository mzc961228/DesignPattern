package com.testantd.demo.service;

import com.testantd.demo.bean.Credit;

import java.util.List;

public interface CreditService{

    public List<Credit> SelectByUserID(int userID);

    public int increaseCredits(int userID, int creditAmount, int duration, int days);

    public int  decreaseCredits(int userID, int requiredEcredits);
}

package com.testantd.demo.bean;

import com.testantd.demo.common.utils.ToolUtils;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Table(name = "")
public class Credit {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer creditId;

    private Integer userId;
    //积分量这块，要设置一下正负，存入数据库的时候好判断是花费还是赚取，以及积分余额的设定。
    private Integer creditAmount;
    //积分余额这块涉及主要积分思想，先去花掉快要过期的积分
    private Integer creditBanlance;
    //积分的来源
    private String creditOrigin;

    private int createTime;
    private int expireTime;

    public Credit( Integer userId, Integer creditAmount, Integer creditBanlance, String creditOrigin,int duration ) {
        this.userId = userId;
        this.creditAmount = creditAmount;
        this.creditBanlance = creditBanlance;
        this.creditOrigin = creditOrigin;
        //设置到期时间为6个月
        Date currentTime = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(currentTime);
        Calendar future=rightNow;
        //duration代表的是积分可使用时长，可由商家来确定，剩下的就是积分规则，签到如何实现和积分的关系了。
        future.add(Calendar.MONTH, duration);
        int expiredTime = ToolUtils.timeExchanger(future.getTime());
        int createTime = ToolUtils.timeExchanger(rightNow.getTime());
        this.createTime=createTime;
        this.expireTime=expiredTime;
    }


    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Integer creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getCreditBanlance() {
        return creditBanlance;
    }

    public void setCreditBanlance(Integer creditBanlance) {
        this.creditBanlance = creditBanlance;
    }


    public int getExpireTime() {
        return expireTime;
    }

//    public void setExpireTime(Integer expireTime) {
//        this.expireTime = expireTime;
//    }

    public String getCreditOrigin() {
        return creditOrigin;
    }

    public void setCreditOrigin(String creditOrigin) {
        //设置积分来源，
        this.creditOrigin = creditOrigin == null ? null : creditOrigin.trim();
    }

    public int getCreateTime() {
        return createTime;
    }

    public static String exchanger(Date time) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        String timestr =  formatter.format(time);
        return timestr;
    }
}
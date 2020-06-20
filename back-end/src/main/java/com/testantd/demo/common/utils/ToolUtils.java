package com.testantd.demo.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolUtils {

    public static int timeExchanger(Date time) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        String timestr =  formatter.format(time);
        int timeNum=Integer.parseInt(timestr);
        return timeNum;
    }
    public static int judge(int expiredTime, int checkTime){
        //返回0即过期
        //先比较年份
        int expiredYear = expiredTime/10000;
        int expiredMonth = expiredTime/100-expiredYear*100;
        int expiredDay = expiredTime-expiredMonth*100;
        int checkYear = checkTime/10000;
        int checkMonth = checkTime/100-checkYear*100;
        int checkDay = checkTime-checkMonth*100;
        if(checkYear<expiredYear){
            return 0;
        }
        else if(checkYear == expiredYear&&checkMonth<expiredMonth){
            return 0;
        }
        else if(checkYear == expiredYear&& checkMonth == expiredMonth&& checkDay<expiredDay){
            return 0;
        }
        else{
            return 1;
        }
    }
}

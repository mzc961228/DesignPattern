package com.testantd.demo.common.entity;

import java.util.HashMap;

public class MyResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public MyResponse(){

    }

    public MyResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public MyResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    public MyResponse errno(Integer errno){
        this.put("errno",errno);
        return this;
    }

    public MyResponse stateCode(String code){
        this.put("stateCode",code);
        return this;
    }

    @Override
    public MyResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_order_goods")
public class OrderGoods {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer order_id;

    private Integer goods_id;

    private String goods_name;

    private String goods_aka;

    private Integer product_id;

    private Integer number;

    private Float retail_price;

    private String goods_specifition_name_value;

    private String goods_specifition_ids;

    private String list_pic_url;

    private Integer user_id;

    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_aka() {
        return goods_aka;
    }

    public void setGoods_aka(String goods_aka) {
        this.goods_aka = goods_aka;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Float retail_price) {
        this.retail_price = retail_price;
    }

    public String getGoods_specifition_name_value() {
        return goods_specifition_name_value;
    }

    public void setGoods_specifition_name_value(String goods_specifition_name_value) {
        this.goods_specifition_name_value = goods_specifition_name_value;
    }

    public String getGoods_specifition_ids() {
        return goods_specifition_ids;
    }

    public void setGoods_specifition_ids(String goods_specifition_ids) {
        this.goods_specifition_ids = goods_specifition_ids;
    }

    public String getList_pic_url() {
        return list_pic_url;
    }

    public void setList_pic_url(String list_pic_url) {
        this.list_pic_url = list_pic_url;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_aka='" + goods_aka + '\'' +
                ", product_id=" + product_id +
                ", number=" + number +
                ", retail_price=" + retail_price +
                ", goods_specifition_name_value='" + goods_specifition_name_value + '\'' +
                ", goods_specifition_ids='" + goods_specifition_ids + '\'' +
                ", list_pic_url='" + list_pic_url + '\'' +
                ", user_id=" + user_id +
                ", is_delete=" + is_delete +
                '}';
    }
}

package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_product")
public class Product {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer goods_id;

    private String goods_specification_ids;

    private String goods_sn;

    private Integer goods_number;

    private Float retail_price;

    private Float cost;

    private Double goods_weight;

    private Integer has_change;

    private String goods_name;

    private Integer is_on_sale;

    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_specification_ids() {
        return goods_specification_ids;
    }

    public void setGoods_specification_ids(String goods_specification_ids) {
        this.goods_specification_ids = goods_specification_ids;
    }

    public String getGoods_sn() {
        return goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public Integer getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Integer goods_number) {
        this.goods_number = goods_number;
    }

    public Float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Float retail_price) {
        this.retail_price = retail_price;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Double getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(Double goods_weight) {
        this.goods_weight = goods_weight;
    }

    public Integer getHas_change() {
        return has_change;
    }

    public void setHas_change(Integer has_change) {
        this.has_change = has_change;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Integer is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", goods_specification_ids='" + goods_specification_ids + '\'' +
                ", goods_sn='" + goods_sn + '\'' +
                ", goods_number=" + goods_number +
                ", retail_price=" + retail_price +
                ", cost=" + cost +
                ", goods_weight=" + goods_weight +
                ", has_change=" + has_change +
                ", goods_name='" + goods_name + '\'' +
                ", is_on_sale=" + is_on_sale +
                ", is_delete=" + is_delete +
                '}';
    }
}

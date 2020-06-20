package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "hiolabs_cart")
public class Cart {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer user_id;

    private Integer goods_id;

    private String goods_sn;

    private Integer product_id;

    private String goods_name;

    private String goods_aka;

    private Double goods_weight;

    private Float add_price;

    private Float retail_price;

    private Integer number;

    private String goods_specifition_name_value;

    private String goods_specifition_ids;

    private Integer checked;

    private String list_pic_url;

    private Integer freight_template_id;

    private Integer is_on_sale;

    private Long add_time;

    private Integer is_fast;

    private Integer is_delete;

    @Transient
    private Float weight_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_sn() {
        return goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public Double getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(Double goods_weight) {
        this.goods_weight = goods_weight;
    }

    public Float getAdd_price() {
        return add_price;
    }

    public void setAdd_price(Float add_price) {
        this.add_price = add_price;
    }

    public Float getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Float retail_price) {
        this.retail_price = retail_price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getList_pic_url() {
        return list_pic_url;
    }

    public void setList_pic_url(String list_pic_url) {
        this.list_pic_url = list_pic_url;
    }

    public Integer getFreight_template_id() {
        return freight_template_id;
    }

    public void setFreight_template_id(Integer freight_template_id) {
        this.freight_template_id = freight_template_id;
    }

    public Integer getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Integer is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public Integer getIs_fast() {
        return is_fast;
    }

    public void setIs_fast(Integer is_fast) {
        this.is_fast = is_fast;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Float getWeight_count() {
        return weight_count;
    }

    public void setWeight_count(Float weight_count) {
        this.weight_count = weight_count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", goods_sn='" + goods_sn + '\'' +
                ", product_id=" + product_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_aka='" + goods_aka + '\'' +
                ", goods_weight=" + goods_weight +
                ", add_price=" + add_price +
                ", retail_price=" + retail_price +
                ", number=" + number +
                ", goods_specifition_name_value='" + goods_specifition_name_value + '\'' +
                ", goods_specifition_ids='" + goods_specifition_ids + '\'' +
                ", checked=" + checked +
                ", list_pic_url='" + list_pic_url + '\'' +
                ", freight_template_id=" + freight_template_id +
                ", is_on_sale=" + is_on_sale +
                ", add_time=" + add_time +
                ", is_fast=" + is_fast +
                ", is_delete=" + is_delete +
                '}';
    }
}

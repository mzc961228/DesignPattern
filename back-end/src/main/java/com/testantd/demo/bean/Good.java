package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import java.text.DecimalFormat;

@Table(name = "hiolabs_goods")
public class Good {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer category_id;

    private Integer is_on_sale;

    private String name;

    private Integer goods_number;

    private Integer sell_volume;

    private String keywords;

    private String retail_price;

    private Float min_retail_price;

    private String cost_price;

    private Float min_cost_price;

    private String goods_brief;

    private String goods_desc;

    private Integer sort_order;

    private Integer is_index;

    private Integer is_new;

    private String goods_unit;

    private String https_pic_url;

    private String list_pic_url;

    private Integer freight_template_id;

    private Integer freight_type;

    private Integer is_delete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(Integer is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Integer goods_number) {
        this.goods_number = goods_number;
    }

    public Integer getSell_volume() {
        return sell_volume;
    }

    public void setSell_volume(Integer sell_volume) {
        this.sell_volume = sell_volume;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(String retail_price) {
        this.retail_price = retail_price;
    }

    public Float getMin_retail_price() {
        return min_retail_price;
    }

    public void setMin_retail_price(Float min_retail_price) {
        this.min_retail_price = min_retail_price;
    }

    public String getCost_price() {
        return cost_price;
    }

    public void setCost_price(String cost_price) {
        this.cost_price = cost_price;
    }

    public Float getMin_cost_price() {
        return min_cost_price;
    }

    public void setMin_cost_price(Float min_cost_price) {
        this.min_cost_price = min_cost_price;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public Integer getIs_index() {
        return is_index;
    }

    public void setIs_index(Integer is_index) {
        this.is_index = is_index;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    public String getHttps_pic_url() {
        return https_pic_url;
    }

    public void setHttps_pic_url(String https_pic_url) {
        this.https_pic_url = https_pic_url;
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

    public Integer getFreight_type() {
        return freight_type;
    }

    public void setFreight_type(Integer freight_type) {
        this.freight_type = freight_type;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", is_on_sale=" + is_on_sale +
                ", name='" + name + '\'' +
                ", goods_number=" + goods_number +
                ", sell_volume=" + sell_volume +
                ", keywords='" + keywords + '\'' +
                ", retail_price='" + retail_price + '\'' +
                ", min_retail_price=" + min_retail_price +
                ", cost_price='" + cost_price + '\'' +
                ", min_cost_price=" + min_cost_price +
                ", goods_brief='" + goods_brief + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", sort_order=" + sort_order +
                ", is_index=" + is_index +
                ", is_new=" + is_new +
                ", goods_unit='" + goods_unit + '\'' +
                ", https_pic_url='" + https_pic_url + '\'' +
                ", list_pic_url='" + list_pic_url + '\'' +
                ", freight_template_id=" + freight_template_id +
                ", freight_type=" + freight_type +
                ", is_delete=" + is_delete +
                '}';
    }
}

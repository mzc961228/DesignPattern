package com.testantd.demo.bean;

import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "hiolabs_goods_specification")
public class GoodsSpecification {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer goods_id;

    private Integer specification_id;

    private String value;

    private String pic_url;

    private Integer is_delete;

    @Transient
    private Integer goods_number;

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

    public Integer getSpecification_id() {
        return specification_id;
    }

    public void setSpecification_id(Integer specification_id) {
        this.specification_id = specification_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Integer getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(Integer goods_number) {
        this.goods_number = goods_number;
    }

    @Override
    public String toString() {
        return "GoodsSpecification{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", specification_id=" + specification_id +
                ", value='" + value + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", is_delete=" + is_delete +
                '}';
    }
}

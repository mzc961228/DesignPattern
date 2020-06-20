package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_goods_gallery")
public class Gallery {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer goods_id;

    private String img_url;

    private String img_desc;

    private Integer sort_order;

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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_desc() {
        return img_desc;
    }

    public void setImg_desc(String img_desc) {
        this.img_desc = img_desc;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", img_url='" + img_url + '\'' +
                ", img_desc='" + img_desc + '\'' +
                ", sort_order=" + sort_order +
                ", is_delete=" + is_delete +
                '}';
    }
}

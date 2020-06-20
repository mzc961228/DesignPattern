package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_ad")
public class Banner {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer link_type;

    private String link;

    private Integer goods_id;

    private String image_url;

    private Integer end_time;

    private Integer enabled;

    private Integer sort_order;

    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLink_type() {
        return link_type;
    }

    public void setLink_type(Integer link_type) {
        this.link_type = link_type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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
        return "IndexController{" +
                "id=" + id +
                ", link_type=" + link_type +
                ", link='" + link + '\'' +
                ", goods_id=" + goods_id +
                ", image_url='" + image_url + '\'' +
                ", end_time=" + end_time +
                ", enabled=" + enabled +
                ", sort_order=" + sort_order +
                ", is_delete=" + is_delete +
                '}';
    }

}

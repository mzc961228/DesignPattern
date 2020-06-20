package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "hiolabs_category")
public class Category {

    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private String keywords;

    private String front_desc;

    private Integer parent_id;

    private Integer sort_order;

    private Integer show_index;

    private Integer is_show;

    private String icon_url;

    @Transient
    private String banner;

    private String img_url;

    private String level;

    private String front_name;

    @Transient
    private Integer height;

    private Integer p_height;

    private Integer is_category;

    private Integer is_channel;

    private List<Good> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFront_desc() {
        return front_desc;
    }

    public void setFront_desc(String front_desc) {
        this.front_desc = front_desc;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public Integer getShow_index() {
        return show_index;
    }

    public void setShow_index(Integer show_index) {
        this.show_index = show_index;
    }

    public Integer getIs_show() {
        return is_show;
    }

    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFront_name() {
        return front_name;
    }

    public void setFront_name(String front_name) {
        this.front_name = front_name;
    }

    public Integer getP_height() {
        return p_height;
    }

    public void setP_height(Integer p_height) {
        this.p_height = p_height;
    }

    public Integer getIs_category() {
        return is_category;
    }

    public void setIs_category(Integer is_category) {
        this.is_category = is_category;
    }

    public Integer getIs_channel() {
        return is_channel;
    }

    public void setIs_channel(Integer is_channel) {
        this.is_channel = is_channel;
    }

    public List<Good> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Good> goodsList) {
        this.goodsList = goodsList;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", front_desc='" + front_desc + '\'' +
                ", parent_id=" + parent_id +
                ", sort_order=" + sort_order +
                ", show_index=" + show_index +
                ", is_show=" + is_show +
                ", icon_url='" + icon_url + '\'' +
                ", img_url='" + img_url + '\'' +
                ", level='" + level + '\'' +
                ", front_name='" + front_name + '\'' +
                ", p_height=" + p_height +
                ", is_category=" + is_category +
                ", is_channel=" + is_channel +
                ", goodsList=" + goodsList +
                '}';
    }
}

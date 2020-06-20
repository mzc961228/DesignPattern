package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_region")
public class Region {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer parent_id;

    private String name;

    private Integer type;

    private Integer agency_id;

    private Integer area;

    private String area_code;

    private Integer far_area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(Integer agency_id) {
        this.agency_id = agency_id;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public Integer getFar_area() {
        return far_area;
    }

    public void setFar_area(Integer far_area) {
        this.far_area = far_area;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", agency_id=" + agency_id +
                ", area=" + area +
                ", area_code=" + area_code +
                ", far_area=" + far_area +
                '}';
    }
}

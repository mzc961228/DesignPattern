package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "hiolabs_address")
public class Address {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private Integer user_id;

    private Integer country_id;

    private Integer province_id;

    private Integer city_id;

    private Integer district_id;

    private String address;

    private String mobile;

    private Integer is_default;

    private Integer is_delete;

    @Transient
    private String province_name;

    @Transient
    private String city_name;

    @Transient
    private String district_name;

    @Transient
    private String full_region;

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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getFull_region() {
        return full_region;
    }

    public void setFull_region(String full_region) {
        this.full_region = full_region;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", country_id=" + country_id +
                ", province_id=" + province_id +
                ", city_id=" + city_id +
                ", district_id=" + district_id +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", is_default=" + is_default +
                ", is_delete=" + is_delete +
                ", province_name='" + province_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", district_name='" + district_name + '\'' +
                ", full_region='" + full_region + '\'' +
                '}';
    }
}

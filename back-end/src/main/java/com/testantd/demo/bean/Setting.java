package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_settings")
public class Setting {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String autoDelivery;

    private String Name;

    private String Tel;

    private String ProvinceName;

    private String CityName;

    private String ExpAreaName;

    private String Address;

    private Integer discovery_img_height;

    private String discovery_img;

    private Integer goods_id;

    private Integer city_id;

    private Integer province_id;

    private Integer district_id;

    private Integer reset;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutoDelivery() {
        return autoDelivery;
    }

    public void setAutoDelivery(String autoDelivery) {
        this.autoDelivery = autoDelivery;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String provinceName) {
        ProvinceName = provinceName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getExpAreaName() {
        return ExpAreaName;
    }

    public void setExpAreaName(String expAreaName) {
        ExpAreaName = expAreaName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getDiscovery_img_height() {
        return discovery_img_height;
    }

    public void setDiscovery_img_height(Integer discovery_img_height) {
        this.discovery_img_height = discovery_img_height;
    }

    public String getDiscovery_img() {
        return discovery_img;
    }

    public void setDiscovery_img(String discovery_img) {
        this.discovery_img = discovery_img;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getReset() {
        return reset;
    }

    public void setReset(Integer reset) {
        this.reset = reset;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", autoDelivery='" + autoDelivery + '\'' +
                ", Name='" + Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", ProvinceName='" + ProvinceName + '\'' +
                ", CityName='" + CityName + '\'' +
                ", ExpAreaName='" + ExpAreaName + '\'' +
                ", Address='" + Address + '\'' +
                ", discovery_img_height=" + discovery_img_height +
                ", discovery_img='" + discovery_img + '\'' +
                ", goods_id=" + goods_id +
                ", city_id=" + city_id +
                ", province_id=" + province_id +
                ", district_id=" + district_id +
                ", reset=" + reset +
                '}';
    }
}

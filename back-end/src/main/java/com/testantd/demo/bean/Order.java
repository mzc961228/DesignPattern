package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "hiolabs_order")
public class Order {

    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String order_sn;

    private Integer user_id;

    private Integer order_status;

    private Integer offline_pay;

    private Integer shipping_status;

    private Integer print_status;

    private Integer pay_status;

    private String consignee;

    private Integer country;

    private Integer province;

    private Integer city;

    private Integer district;

    private String address;

    private String print_info;

    private String mobile;

    private String postscript;

    private String admin_memo;

    private Float shipping_fee;

    private String pay_name;

    private String pay_id;

    private Float change_price;

    private Float actual_price;

    private Float order_price;

    private Float goods_price;

    private Long add_time;

    private Integer pay_time;

    private Integer shipping_time;

    private Integer confirm_time;

    private Integer dealdone_time;

    private Integer freight_price;

    private Float express_value;

    private String remark;

    private Integer order_type;

    private Integer is_delete;

    @Transient
    private List<OrderGoods> goodsList;

    @Transient
    private int goodsCount;

    @Transient
    private String order_status_text;

    @Transient
    private OrderOperation handleOption;

    @Transient
    private String province_name;

    @Transient
    private String city_name;

    @Transient
    private String district_name;

    @Transient
    private String full_region;

    @Transient
    private Long final_pay_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Integer getOffline_pay() {
        return offline_pay;
    }

    public void setOffline_pay(Integer offline_pay) {
        this.offline_pay = offline_pay;
    }

    public Integer getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(Integer shipping_status) {
        this.shipping_status = shipping_status;
    }

    public Integer getPrint_status() {
        return print_status;
    }

    public void setPrint_status(Integer print_status) {
        this.print_status = print_status;
    }

    public Integer getPay_status() {
        return pay_status;
    }

    public void setPay_status(Integer pay_status) {
        this.pay_status = pay_status;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrint_info() {
        return print_info;
    }

    public void setPrint_info(String print_info) {
        this.print_info = print_info;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public String getAdmin_memo() {
        return admin_memo;
    }

    public void setAdmin_memo(String admin_memo) {
        this.admin_memo = admin_memo;
    }

    public Float getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(Float shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getPay_name() {
        return pay_name;
    }

    public void setPay_name(String pay_name) {
        this.pay_name = pay_name;
    }

    public String getPay_id() {
        return pay_id;
    }

    public void setPay_id(String pay_id) {
        this.pay_id = pay_id;
    }

    public Float getChange_price() {
        return change_price;
    }

    public void setChange_price(Float change_price) {
        this.change_price = change_price;
    }

    public Float getActual_price() {
        return actual_price;
    }

    public void setActual_price(Float actual_price) {
        this.actual_price = actual_price;
    }

    public Float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Float order_price) {
        this.order_price = order_price;
    }

    public Float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Float goods_price) {
        this.goods_price = goods_price;
    }

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public Integer getPay_time() {
        return pay_time;
    }

    public void setPay_time(Integer pay_time) {
        this.pay_time = pay_time;
    }

    public Integer getShipping_time() {
        return shipping_time;
    }

    public void setShipping_time(Integer shipping_time) {
        this.shipping_time = shipping_time;
    }

    public Integer getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(Integer confirm_time) {
        this.confirm_time = confirm_time;
    }

    public Integer getDealdone_time() {
        return dealdone_time;
    }

    public void setDealdone_time(Integer dealdone_time) {
        this.dealdone_time = dealdone_time;
    }

    public Integer getFreight_price() {
        return freight_price;
    }

    public void setFreight_price(Integer freight_price) {
        this.freight_price = freight_price;
    }

    public Float getExpress_value() {
        return express_value;
    }

    public void setExpress_value(Float express_value) {
        this.express_value = express_value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getOrder_status_text() {
        return order_status_text;
    }

    public void setOrder_status_text(String order_status_text) {
        this.order_status_text = order_status_text;
    }

    public OrderOperation getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(OrderOperation handleOption) {
        this.handleOption = handleOption;
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

    public Long getFinal_pay_time() {
        return final_pay_time;
    }

    public void setFinal_pay_time(Long final_pay_time) {
        this.final_pay_time = final_pay_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_sn='" + order_sn + '\'' +
                ", user_id=" + user_id +
                ", order_status=" + order_status +
                ", offline_pay=" + offline_pay +
                ", shipping_status=" + shipping_status +
                ", print_status=" + print_status +
                ", pay_status=" + pay_status +
                ", consignee='" + consignee + '\'' +
                ", country=" + country +
                ", province=" + province +
                ", city=" + city +
                ", district=" + district +
                ", address='" + address + '\'' +
                ", print_info='" + print_info + '\'' +
                ", mobile='" + mobile + '\'' +
                ", postscript='" + postscript + '\'' +
                ", admin_memo='" + admin_memo + '\'' +
                ", shipping_fee=" + shipping_fee +
                ", pay_name='" + pay_name + '\'' +
                ", pay_id='" + pay_id + '\'' +
                ", change_price=" + change_price +
                ", actual_price=" + actual_price +
                ", order_price=" + order_price +
                ", goods_price=" + goods_price +
                ", add_time=" + add_time +
                ", pay_time=" + pay_time +
                ", shipping_time=" + shipping_time +
                ", confirm_time=" + confirm_time +
                ", dealdone_time=" + dealdone_time +
                ", freight_price=" + freight_price +
                ", express_value=" + express_value +
                ", remark='" + remark + '\'' +
                ", order_type=" + order_type +
                ", is_delete=" + is_delete +
                ", goodsList=" + goodsList +
                ", goodsCount=" + goodsCount +
                ", order_status_text='" + order_status_text + '\'' +
                ", handleOption=" + handleOption +
                ", province_name='" + province_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", district_name='" + district_name + '\'' +
                ", full_region='" + full_region + '\'' +
                '}';
    }
}

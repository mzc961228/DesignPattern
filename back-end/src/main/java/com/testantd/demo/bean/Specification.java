package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_specification")
public class Specification {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private Integer sort_order;

    private String memo;

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

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sort_order=" + sort_order +
                ", memo='" + memo + '\'' +
                '}';
    }
}

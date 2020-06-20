package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_notice")
public class Notice {

    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String content;

    private Integer end_time;

    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", end_time=" + end_time +
                ", is_delete=" + is_delete +
                '}';
    }
}

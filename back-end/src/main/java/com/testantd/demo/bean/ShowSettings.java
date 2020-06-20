package com.testantd.demo.bean;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Table(name = "hiolabs_show_settings")
public class ShowSettings {
    @javax.persistence.Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer banner;

    private Integer channel;

    private Integer index_banner_img;

    private Integer notice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBanner() {
        return banner;
    }

    public void setBanner(Integer banner) {
        this.banner = banner;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getIndex_banner_img() {
        return index_banner_img;
    }

    public void setIndex_banner_img(Integer index_banner_img) {
        this.index_banner_img = index_banner_img;
    }

    public Integer getNotice() {
        return notice;
    }

    public void setNotice(Integer notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "ShowSettings{" +
                "id=" + id +
                ", banner=" + banner +
                ", channel=" + channel +
                ", index_banner_img=" + index_banner_img +
                ", notice=" + notice +
                '}';
    }
}

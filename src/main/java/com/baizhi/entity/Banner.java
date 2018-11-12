package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String imgPath;
    private String banner_desc;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date banner_date;

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", banner_desc='" + banner_desc + '\'' +
                ", status='" + status + '\'' +
                ", banner_date=" + banner_date +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getBanner_desc() {
        return banner_desc;
    }

    public void setBanner_desc(String banner_desc) {
        this.banner_desc = banner_desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBanner_date() {
        return banner_date;
    }

    public void setBanner_date(Date banner_date) {
        this.banner_date = banner_date;
    }

    public Banner() {
    }

    public Banner(String id, String title, String imgPath, String banner_desc, String status, Date banner_date) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.banner_desc = banner_desc;
        this.status = status;
        this.banner_date = banner_date;
    }
}

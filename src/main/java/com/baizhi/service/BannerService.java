package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    //查询所有
    List<Banner> findByBannerAll();
    //增加
    void addBanner(Banner banner);
    //修改
    void motifyBanner(Banner banner);
    //删除
    void removeBanner(String id);
    //查询一个
    Banner findByOne(String id);
}

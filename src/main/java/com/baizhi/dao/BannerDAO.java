package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDAO{
    //查询所有
    List<Banner> queryByBannerAll();
    //增加
    void insertBanner(Banner banner);
    //修改
    void updateBanner(Banner banner);
    //删除
    void deleteBanner(String id);
    //查询一个
    Banner queryByOne(String id);
}

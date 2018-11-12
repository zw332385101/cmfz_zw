package com.baizhi.service;
import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;

    @Override
    public List<Banner> findByBannerAll() {
        List<Banner> banners = bannerDAO.queryByBannerAll();
        return  banners;
    }

    @Override
    public void addBanner(Banner banner) {
        bannerDAO.insertBanner(banner);

    }

    @Override
    public void motifyBanner(Banner banner) {
        bannerDAO.updateBanner(banner);
    }

    @Override
    public void removeBanner(String id) {
        bannerDAO.deleteBanner(id);

    }

    @Override
    public Banner findByOne(String id) {
        Banner banner = bannerDAO.queryByOne(id);
        return banner;
    }
}

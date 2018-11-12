package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/findBannerAll")
    public @ResponseBody List<Banner> findBannerAll(){
        List<Banner> byBannerAll = bannerService.findByBannerAll();
        return byBannerAll;
    }
    @RequestMapping("/addBanner")
    public @ResponseBody Map<String,Object> addBanner(Banner banner,MultipartFile aas,HttpServletRequest request){
        HashMap<String, Object> results = new HashMap<>();
        try{
            banner.setId(UUID.randomUUID().toString());
            String realPaths = request.getRealPath("back/images");
            aas.transferTo(new File(realPaths,aas.getOriginalFilename()));
            banner.setImgPath("/back/images/"+aas.getOriginalFilename());
            bannerService.addBanner(banner);
            results.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }

    @RequestMapping("/findByOne")
    public @ResponseBody Banner findByOne(String id){
        Banner byOne = bannerService.findByOne(id);
        return  byOne;
    }

    @RequestMapping("/motifyBanner")
    public @ResponseBody void motifyBanner(Banner banner){
        bannerService.motifyBanner(banner);
    }

    @RequestMapping("/removeBanner")
    public @ResponseBody void removeBanner(String[] id){
        for(int i=0;i<id.length;i++){
            bannerService.removeBanner(id[i]);
        }
    }
}

package com.baizhi.test;


import com.baizhi.dao.AdminDao;
import com.baizhi.entity.*;
import com.baizhi.service.*;
import com.baizhi.util.AlbumUtil;
import com.baizhi.util.MD5Util;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminTest {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AdminService adminService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private BannerService bannerService;
    @Autowired
    private UserService userService;

    @Test
    public void queryBynameAndPasspwrd(){
        Admin byOne = adminService.findByOne("1");
        System.out.println(byOne);
    }

    @Test
    public void updatePassword(){
        Admin admin = new Admin();
        admin.setId("1");
        admin.setPassword("root");
        adminService.motifyAdminPassword(admin);
    }
    @Test
    public void queryAll(){
        List<Menu> menus = menuService.findAll();
        System.out.println(menus);
    }
    /*
    *Banner测试
     */
    @Test
    public void findByBannerAll(){
        List<Banner> byBannerAll = bannerService.findByBannerAll();
        System.out.println(byBannerAll);
    }
    @Test
    public void addBanner(){
        Banner banner = new Banner();
        banner.setId("5");
        banner.setTitle("AAAA");
        banner.setImgPath("back/1.jpg");
        banner.setStatus("y");
        banner.setBanner_desc("ssss");
        banner.setBanner_date(new Date());
        bannerService.addBanner(banner);
    }
    @Test
    public void motifyBanner(){
        Banner banner = new Banner();
        banner.setId("5");
        banner.setTitle("BBBB");
        banner.setImgPath("back/1.jpg");
        banner.setStatus("y");
        banner.setBanner_desc("ssss");
        banner.setBanner_date(new Date());
        bannerService.motifyBanner(banner);
    }
    @Test
    public void removeBanner(){
        bannerService.removeBanner("5");
    }
    @Test
    public void findByOne(){
        Banner byOne = bannerService.findByOne("5");
        System.out.println(byOne);

    }
    @Test
    public  void Alums(){
        List<Album> byAlbumAll = albumService.findByAlbumAll();
        System.out.println(byAlbumAll);
    }
    @Test
    public void Alumss(){
        List<Album> byAlbumAll = albumService.findByAlbumAll();
        System.out.println(byAlbumAll);
    }
    @Test
    public void user(){
        User user = new User();
        user.setId("12");
        user.setPhoneNum("1231123");
        userService.motifyUser(user);
    }

    //获取时长
    @Test
    public void Tess(){
            File file = new File("H:/CloudMusic/1.mp3");
            try {
                MP3File f = (MP3File)AudioFileIO.read(file);
                MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
                System.out.println(audioHeader.getTrackLength());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        @Test
    public void md5(){
            String userName = "zhangsan";
            String passWord = "123456";
            //加密后密码
            String MDPassWord = MD5Util.getMd5(passWord);
            System.out.println("加密前密码:"+passWord);
            System.out.println("加密后密码:"+MDPassWord);
        }
}

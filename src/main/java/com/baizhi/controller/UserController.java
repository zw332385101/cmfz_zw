package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByUserAll")
    public @ResponseBody List<User> findByUserAll(){
        List<User> byUserAll = userService.findByUserAll();
        return  byUserAll;
    }

    @RequestMapping("/addUser")
    public @ResponseBody void addUser(User user) throws IOException {
        String MDPassWord = MD5Util.getMd5(user.getPassword());
        user.setPassword(MDPassWord);
        userService.addUser(user);
    }

    @RequestMapping("/motifyUser")
    public @ResponseBody void motifyUser(User user){
        String MDPassWord = MD5Util.getMd5(user.getPassword());
        user.setPassword(MDPassWord);
        userService.motifyUser(user);
    }

    @RequestMapping("/removeUser")
    public @ResponseBody void removeUser(String id){
            userService.removeUser(id);
    }
}

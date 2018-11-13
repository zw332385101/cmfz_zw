package com.baizhi.controller;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request, String code){
        System.out.println("第一次");
        boolean bynameAndPasspwrd = adminService.findBynameAndPasspwrd(admin);
        HttpSession session = request.getSession();
        String validationCode = (String) session.getAttribute("validationCode");
        if(validationCode.equals(code)){
            if(bynameAndPasspwrd){
                String id = adminService.findByName(admin.getName());
                session.setAttribute("id",id);
                session.setAttribute("admin",admin);
               // System.out.println("登录信息"+admin);
                return "back/main/main";
            }else {
                return "back/login";
            }
        }else{
            return "back/login";
        }
    }

    @RequestMapping("/updateAdminPassword")
    public String updateAdminPassword(Admin admin){
       System.out.println("修改收到的参数"+admin);
        adminService.motifyAdminPassword(admin);
        return "back/login";
    }

    @RequestMapping("/tuichu")
    public String tuichu(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "back/login";
    }
}

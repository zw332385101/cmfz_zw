package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public boolean findBynameAndPasspwrd(Admin admin) {
        Admin admin1 = adminDao.queryBynameAndPasspwrd(admin);
        if(admin1!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void motifyAdminPassword(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public Admin findByOne(String id) {
        Admin admin = adminDao.queryOne(id);
        return admin;
    }

    @Override
    public String findByName(String name) {
        String id=adminDao.queryByName(name);
        return id;
    }
}

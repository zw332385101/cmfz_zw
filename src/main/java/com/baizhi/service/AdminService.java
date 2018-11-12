package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    boolean findBynameAndPasspwrd(Admin admin);
    void motifyAdminPassword(Admin admin);
    Admin findByOne(String id);
    String findByName(String name);
}

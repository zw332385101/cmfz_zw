package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao extends BaseDao<Admin>{
    Admin queryBynameAndPasspwrd(Admin admin);
    void updateAdmin(Admin admin);
    String queryByName(String name);

}

package com.baizhi.dao;


import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {
    //查询所有
    List<User> queryByUserAll();
    //增加
    void insertUser(User user);
    //修改
    void updateUser(User user);
    //删除
    void deleteUser(String id);
    //查询一个
    User queryByOne(String id);
}

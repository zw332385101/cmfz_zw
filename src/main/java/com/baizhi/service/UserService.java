package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    List<User> findByUserAll();
    //增加
    void addUser(User user);
    //修改
    void motifyUser(User user);
    //删除
    void removeUser(String id);
    //查询一个
    User findByOne(String id);
}

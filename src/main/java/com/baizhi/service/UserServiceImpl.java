package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public List<User> findByUserAll() {
        List<User> users = userDAO.queryByUserAll();
        return users;
    }

    @Override
    public void addUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public void motifyUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void removeUser(String id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User findByOne(String id) {
        User user = userDAO.queryByOne(id);
        return user;
    }
}

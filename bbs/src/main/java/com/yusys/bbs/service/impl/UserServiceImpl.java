package com.yusys.bbs.service.impl;


import com.yusys.bbs.dao.UserDao;
import com.yusys.bbs.entity.User;
import com.yusys.bbs.service.UserService;
import com.yusys.bbs.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public List<User> selectAllUserByPage(int page) {
        return userDao.selectAllUserByPage(page);
    }

    @Override
//    @Cacheable(value="selectUserByTel-key")
    public User selectUserByTel(String tel) {
        return userDao.selectUserByTel(tel);
    }

    @Override
    public void addUser(String nickname, String tel, String password) {
        password = MD5Utils.getMD5(password);
        userDao.addUser(nickname, tel, password);
    }

    @Override
//    @Cacheable(value="selectUser-key")
    public User selectUser(String tel, String password) {
        password = MD5Utils.getMD5(password);
        return userDao.selectUser(tel, password);
    }
}

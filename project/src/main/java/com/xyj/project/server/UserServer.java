package com.xyj.project.server;

import com.xyj.project.dao.UserDao;
import com.xyj.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServer {

    @Autowired
    private UserDao userDao;

    public boolean isExist(String username) {
        User user = userDao.findByUsername(username);
        return null != user;
    }

    public User get(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    public void save(User user) {
        userDao.save(user);
    }
}

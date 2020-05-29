package com.xyj.project.dao;

import com.xyj.project.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    public User findByUsernameAndPassword(String username, String password);

}

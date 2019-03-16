package com.example.spring_boot_demo.dao;

import com.example.spring_boot_demo.pojo.User;

import java.util.List;


public interface UserMapper{

    List<User> selectUserList();

    int updateVersionById(User user);

    User selectById(Integer userId);
}

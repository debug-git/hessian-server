package com.example.spring_boot_demo.service.impl;

import com.example.spring_boot_demo.dao.UserMapper;
import com.example.spring_boot_demo.pojo.User;
import com.example.spring_boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUserPage() {
        return userMapper.selectUserList();
    }
}

package com.example.spring_boot_demo.service.impl;

import com.example.spring_boot_demo.dao.UserMapper;
import com.example.spring_boot_demo.pojo.User;
import com.example.spring_boot_demo.service.UserService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUserPage() {
        return userMapper.selectUserList();
    }

    @Override
    public int addVersionById(User user) {
        System.out.println("修改之前。。。");
        Integer i = userMapper.updateVersionById(user);
        System.out.println("修改之后。。。");
        return i;
    }

    @Override
    public synchronized int kkk() {
        User user = userMapper.selectById(1);
        user.setCount(user.getCount() + 1);
        return this.addVersionById(user);
    }
}

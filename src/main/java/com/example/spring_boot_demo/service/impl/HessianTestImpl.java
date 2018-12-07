package com.example.spring_boot_demo.service.impl;

import com.example.spring_boot_demo.service.HessianTest;
import org.springframework.stereotype.Service;

@Service
public class HessianTestImpl implements HessianTest {
    @Override
    public String test(String name) {
        System.out.println("调用服务端方法");
        return "Hello "+name+"。这是服务端返回的消息";
    }
}

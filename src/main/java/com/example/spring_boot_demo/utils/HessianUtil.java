package com.example.spring_boot_demo.utils;

import com.example.spring_boot_demo.service.HessianTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

@Component
public class HessianUtil {

    @Autowired
    private HessianTest hessianTest;

    //发布服务
    @Bean(name = "/hessian/test")
    public HessianServiceExporter exportHessianService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessianTest);
        exporter.setServiceInterface(HessianTest.class);
        return exporter;
    }
}

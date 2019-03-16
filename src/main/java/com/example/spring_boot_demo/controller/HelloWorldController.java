package com.example.spring_boot_demo.controller;

import com.example.spring_boot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * ---------------------------------
 */

@RestController
//@Controller
public class HelloWorldController {
    @Value("${content}")
    private String content;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index() {
        // 分页查询 10 条姓名为‘张三’的用户记录
//        List<User> userList = userMapper.selectPage(
//                new Page<User>(1, 10),
//                new EntityWrapper<User>().eq("name", "张三")
//        );

        // 初始化 影响行数
//        int result = 0;
//        // 初始化 User 对象
//        User user = new User();
//        // 插入 User (插入成功会自动回写主键到实体类)
//        user.setUserName("Tom");
//        result = userMapper.insert(user);


        return "Hello World!content:"+content;
    }

    @RequestMapping("/page")
    public Object selectPage(Model model){
        List f = new ArrayList<>();
        f = userService.selectUserPage();
        return f;
    }

//    @RequestMapping("/addVersion")
//    public Integer addVersion(Model model){
//        Integer i = userService.addVersionById(1);
//        System.out.println("执行完了...");
//        return i;
//    }

}
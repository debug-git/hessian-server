package com.example.spring_boot_demo.pojo;

//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
//import org.springframework.context.annotation.Bean;

import java.util.Date;

// @TableName("user")
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;
    private Date modifyTime;

    //该属性在表中不存在
//    @TableField(exist = false)
    private String state;

    public User(Integer userId, String userName, String password, String phone, String state) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.state = state;
    }

    public User() {
        System.out.println("父类默认构造方法");
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", modifyTime=" + modifyTime +
                ", state='" + state + '\'' +
                '}';
    }
}

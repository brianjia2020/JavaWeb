package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.RegisterUser(new User(null,"bbj","666","bbj@666.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin",null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("admin")){
            System.out.println("This username exists");
        } else {
            System.out.println("This username is available");
        }
    }
}
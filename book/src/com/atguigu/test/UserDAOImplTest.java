package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDAO;
import com.atguigu.dao.impl.UserDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        User user = userDAO.queryUserByUsername("admin");
        if (user == null){
            System.out.println("The user does not exist and you can use it.");
        } else {
            System.out.println("The user exists.");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDAO.queryUserByUsernameAndPassword("admin","admin1");
        if (user == null){
            System.out.println("The username and password are wrong");
        } else {
            System.out.println("Login successfully.");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDAO.saveUser(new User(null,"brianjia","12345","brianjia1123@gmail.com")));
    }
}
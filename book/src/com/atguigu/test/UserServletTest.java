package com.atguigu.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("This is login() method being called up.");
    }

    public void regist(){
        System.out.println("This is regist() method being called up.");
    }

    public void updateUser(){
        System.out.println("This is updateUser() method being called up.");
    }

    public void updatePassword(){
        System.out.println("This is updatePassword() method being called up.");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

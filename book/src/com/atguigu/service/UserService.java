package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
    public void RegisterUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}

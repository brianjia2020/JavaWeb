package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDAO {
    /*
     * 1. if return null, there is no matching username
     */
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);


}

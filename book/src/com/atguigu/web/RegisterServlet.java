package com.atguigu.web;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1. get the parameter of form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String email = req.getParameter("email");

        //2. check the security code
        if("abcde".equalsIgnoreCase(code)){
            if (userService.existUsername(username)){
                req.setAttribute("msg","username already exists");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                System.out.println("This username exists: " + username);

                req.setAttribute("msg","username or passsword is wrong");
                req.setAttribute("username",username);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.RegisterUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg","code is wrong.");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("The security is wrong: " + code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }
}

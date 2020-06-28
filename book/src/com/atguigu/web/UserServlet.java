package com.atguigu.web;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        //System.out.println(action);
        if ("login".equals(action)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            User loginUser = userService.login(new User(null, username, password, null));

            if (loginUser == null) {
//                System.out.println("Username or password are wrong. Log in failed");
                req.setAttribute("msg", "Username or password are wrong. Log in failed");
                req.setAttribute("username", username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("user",loginUser);
//                System.out.println("Log in Successfully.");
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            }
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get the parameter of form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String email = req.getParameter("email");
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        //2. check the security code

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                req.setAttribute("msg", "username already exists");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                System.out.println("This username exists: " + username);

                req.setAttribute("msg", "username or passsword is wrong");
                req.setAttribute("username", username);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.RegisterUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "code is wrong.");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("The security is wrong: " + code);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}

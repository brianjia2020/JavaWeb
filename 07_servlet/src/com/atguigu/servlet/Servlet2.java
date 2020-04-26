package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("username: " + username);

        Object key1 = req.getAttribute("key");
        System.out.println("Whether we received the stamp from servlet1: " + key1);

        System.out.println("Servlet2 is handling the business logic.");
    }
}

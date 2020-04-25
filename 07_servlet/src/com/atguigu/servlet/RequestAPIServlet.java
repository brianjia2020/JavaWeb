package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.
        System.out.println("URI =>" + req.getRequestURI());
        //2.
        System.out.println("URL =>" + req.getRequestURL());
        //3. host ip address
        System.out.println("Host ip =>" + req.getRemoteHost());
        //4. request header
        System.out.println("Request header => " + req.getHeader("User-Agent"));
        System.out.println("Request header => " + req.getHeader("Host"));
        //5. request method
        System.out.println("Request method => " + req.getMethod());
    }
}

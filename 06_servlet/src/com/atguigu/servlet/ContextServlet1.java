package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextServlet1")
public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get servlet config class
        ServletConfig servletConfig = getServletConfig();
        ServletContext context = getServletContext();
        context.setAttribute("key1","value1");
        System.out.println("the value of context attribute is "+ context.getAttribute("key1"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get servlet config class
        ServletConfig servletConfig = getServletConfig();
        ServletContext context = getServletContext();
        context.setAttribute("key1","value1");
        System.out.println("the value of context attribute is "+ context.getAttribute("key1"));
    }
}

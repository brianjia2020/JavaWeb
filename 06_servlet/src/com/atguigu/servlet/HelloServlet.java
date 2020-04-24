package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("1. constructor method");
    }

    public void doGet(){
        System.out.println("get request");
    }

    public void doPost(){
        System.out.println("post request");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. method to initiate");
        //1.to get the alias of the servlet config
        System.out.println("Hello, the alias of this servlet program is " + servletConfig.getServletName());
        //2. get init params
        System.out.println("the initiation parameters are" + servletConfig.getInitParameter("username"));
        //3, get servlet context class
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
     * service function is to handle request and response
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("3. main service method. Hello Servlet, this is brian jia.");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if (method.equals("POST")) {
            doGet();
        } else {
            doPost();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. destroy method.");
    }
}

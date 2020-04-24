package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.DoubleToIntFunction;

public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("rewrite the init function. i have done something.");
    }

    /**
     * doGet() to be called up when there is a get request
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2, this is a doget method");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("Hello, the alias of this servlet program is " + servletConfig.getServletName());
        System.out.println("the initiation parameters are" + servletConfig.getInitParameter("username"));

    }

    /**
     * doPost() to be called up when there is a post request
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2, this is a doPost method");
    }
}

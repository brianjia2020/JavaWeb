package com.atguigu.web;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Passed through the front end client program");
        //1. get request parameter - pageNO and pageSize
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. bookService.page(pageNO,pageSize) return a Page object
        Page<Book> page = bookService.page(pageNO,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3. save Page object to request Scope
        req.setAttribute("page",page);
        //4. request redirect to /pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Passed through the front end client program");
        //1. get request parameter - pageNO and pageSize
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"),1);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }

        if (req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        //2. bookService.page(pageNO,pageSize) return a Page object
        Page<Book> page = bookService.pageByPrice(pageNO,pageSize,min,max);
        page.setUrl(sb.toString());
        //3. save Page object to request Scope
        req.setAttribute("page",page);
        //4. request redirect to /pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}

package com.atguigu.web;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the pageNO param is"+req.getParameter("pageNO"));
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"),0);
        pageNO += 1;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+pageNO);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get request parameter - pageNO and pageSize
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. bookService.page(pageNO,pageSize) return a Page object
        Page<Book> page = bookService.page(pageNO,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //3. save Page object to request Scope
        req.setAttribute("page",page);
        //4. request redirect to /pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        System.out.println(id);
        bookService.deleteBookByID(id);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+req.getParameter("pageNO"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get request parameter and turn into Book object
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2. bookService.updateBook(book)
        bookService.updateBook(book);
        //3. redirect to /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+req.getParameter("pageNO"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get Parameter, book id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2. bookService.queryBookByID
        Book book = bookService.queryBookByID(id);
        //3. save Book to request scope
        req.setAttribute("book",book);
        //4. request dispatch to pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. use bookService to query all books
        List<Book> books = bookService.queryBooks();
        //2. save all books to request scope
        req.setAttribute("books",books);
        //3. dispatch to /pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

}

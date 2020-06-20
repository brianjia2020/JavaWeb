package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookByID(Integer id) {
        bookDAO.deleteBookByID(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBookByID(book);
    }

    @Override
    public Book queryBookByID(Integer id) {
        return bookDAO.queryBookByID(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNO, int pageSize) {
        Page<Book> page = new Page<>();

        //page.setPageNO(pageNO);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal += 1;
        }
        //page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNO(pageNO);



        int begin = (page.getPageNO()-1)*pageSize;
        List<Book> items = bookDAO.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //page.setPageNO(pageNO);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal += 1;
        }
        //page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNO(pageNO);



        int begin = (page.getPageNO()-1)*pageSize;
        List<Book> items = bookDAO.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}

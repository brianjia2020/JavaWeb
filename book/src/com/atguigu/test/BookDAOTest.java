package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null,"brianjia love you","brianjia",new BigDecimal(190),100,0,null));
    }

    @Test
    public void deleteBookByID() {
        bookDAO.deleteBookByID(21);
    }

    @Test
    public void updateBookByID() {
        bookDAO.updateBookByID(new Book(21,"brianjia love you","brianjia",new BigDecimal(190),100,1,null));
    }

    @Test
    public void queryBookByID() {
        System.out.println(bookDAO.queryBookByID(21));
    }

    @Test
    public void queryBooks() {
        bookDAO.queryBooks().forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        bookDAO.queryForPageItems(2,4).forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDAO.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        bookDAO.queryForPageItemsByPrice(2,4,10,50).forEach(System.out::println);
    }
}
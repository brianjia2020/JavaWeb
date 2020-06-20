package com.atguigu.test;

import com.atguigu.bean.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"bookServiceImpl","1123",new BigDecimal(129.00),10000,0,null));
    }

    @Test
    public void deleteBookByID() {
        bookService.deleteBookByID(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"bookServiceImpl","1124",new BigDecimal(129.00),10000,0,null));
    }

    @Test
    public void queryBookByID() {
        System.out.println(bookService.queryBookByID(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1,4));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(0,4,10,50));
    }
}
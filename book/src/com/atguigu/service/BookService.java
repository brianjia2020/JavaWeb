package com.atguigu.service;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookByID(Integer id);
    public void updateBook(Book book);
    public Book queryBookByID(Integer id);
    public List<Book> queryBooks();

    Page<Book> page(int pageNO, int pageSize);

    Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max);
}

package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

public interface BookDAO {
    public int addBook(Book book);
    public int deleteBookByID(Integer id);
    public int updateBookByID(Book book);
    public Book queryBookByID(Integer id);
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}

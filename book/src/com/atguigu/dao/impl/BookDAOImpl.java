package com.atguigu.dao.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDAO;

import java.util.List;

public class BookDAOImpl extends BaseDAO implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "insert into book.t_book(`name`,`price`,`author`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookByID(Integer id) {
        String sql = "delete from book.t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBookByID(Book book) {
        String sql = "update book.t_book set `name` = ?,`price`=?,`author`=?,`sales`=?,`stock`=?,`img_path`=? where `id` =?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookByID(Integer id) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` from book.t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` from book.t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from book.t_book;";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` from book.t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from book.t_book where price between ? and ? order by price";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` from book.t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min,max,begin, pageSize);
    }


}

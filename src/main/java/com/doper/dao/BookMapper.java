package com.doper.dao;

import com.doper.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Book book);

    int deleteBookById(@Param("bookID") int id);

    int updateBook(Book book);

    Book queryBookById(@Param("bookID") int id);

    Book queryBook(@Param("name") String name);

    List<Book> queryBookByName(@Param("name")String name);

    List<Book> queryAllBook();
}

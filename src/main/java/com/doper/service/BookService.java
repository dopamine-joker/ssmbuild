package com.doper.service;

import com.doper.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Book book);

    int deleteBookById(int id);

    int updateBook(Book book);

    Book queryBookById(int id);

    Book queryBook(@Param("name") String name);

    List<Book> queryBookByName(String name);

    List<Book> queryAllBook();
}

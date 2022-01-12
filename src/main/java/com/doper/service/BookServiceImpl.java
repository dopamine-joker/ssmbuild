package com.doper.service;

import com.doper.dao.BookMapper;
import com.doper.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookMapper mapper;

    @Autowired
    public BookServiceImpl(BookMapper mapper) {
        this.mapper = mapper;
    }

//    public void setMapper(BookMapper mapper) {
//        this.mapper = mapper;
//    }

    @Override
    public int addBook(Book book) {
        return mapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return mapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return mapper.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return mapper.queryBookById(id);
    }

    @Override
    public Book queryBook(String name) {
        return mapper.queryBook(name);
    }

    @Override
    public List<Book> queryBookByName(String name) {
        return mapper.queryBookByName(name);
    }

    @Override
    public List<Book> queryAllBook() {
        return mapper.queryAllBook();
    }
}

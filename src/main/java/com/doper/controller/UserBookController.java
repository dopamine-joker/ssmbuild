package com.doper.controller;

import com.doper.exception.sqlBookException;
import com.doper.pojo.Book;
import com.doper.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class UserBookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Book> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }

    @PostMapping(value = "/queryBook", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String queryBook(@RequestParam("name") String name) throws JsonProcessingException {
        List<Book> books = bookService.queryBookByName(name);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(books);
    }

}

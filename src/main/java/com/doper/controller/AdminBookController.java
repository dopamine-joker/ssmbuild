package com.doper.controller;


import com.doper.exception.sqlBookException;
import com.doper.pojo.Book;
import com.doper.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/toAddBook")
    public String toAdd() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String add(@Valid Book book, BindingResult bindingResult,
                      @RequestParam("bookPic") CommonsMultipartFile pic,
                      HttpServletRequest request) throws sqlBookException, IOException {

        // 1. 保存图片
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if(!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件地址: " + realPath);
        String picName = String.format("%s/%s-%s", realPath, UUID.randomUUID(), pic.getOriginalFilename());
        pic.transferTo(new File(picName));
        // 2. 插入数据
        System.out.println("addBook:" + book);
        if(!bindingResult.hasErrors()) {
            Book tmp = bookService.queryBook(book.getBookName());
            if(tmp != null) {
                throw new sqlBookException("already have this book" + book.getBookName());
            }
            bookService.addBook(book);
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/updateBook")
    public String update(Book book) {
        System.out.println("updateBook:" + book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Model model, @RequestParam("id") int id) {
        Book book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/deleteBook/{id}")
    public String delete(@PathVariable int id) {
        System.out.println("delete book, id=" + id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}

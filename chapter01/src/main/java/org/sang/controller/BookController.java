package org.sang.controller;

import org.sang.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private Book book;
    @GetMapping("/book")
    public String book(){
        return book.toString();
    }

    @GetMapping("/books")
    public ModelAndView books(){
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("红楼梦");
        b1.setAuthor("曹雪芹");
        Book b2 = new Book();
        b2.setId(2);
        b2.setName("水浒传");
        b2.setAuthor("施耐庵");
        books.add(b1);
        books.add(b2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books",books);
        modelAndView.setViewName("books");
        return modelAndView;
    }
}

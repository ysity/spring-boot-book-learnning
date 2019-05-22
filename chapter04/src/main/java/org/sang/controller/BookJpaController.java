package org.sang.controller;

import org.sang.domain.Book;
import org.sang.service.BookJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookJpaController {

    @Autowired
    private BookJpaService bookJpaService;
    @GetMapping("/findAll")
    public void findAll(){
        PageRequest pageRequest = new PageRequest(2,3);
        Page<Book> page = bookJpaService.getBookByPage(pageRequest);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("查询结果：" + page.getContent());
        System.out.println("当前页数：" + page.getNumber()+1);
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        System.out.println("每页记录数：" + page.getSize());
    }

    @GetMapping("/search")
    public void search(){
        List<Book> bs1 = bookJpaService.getBookByIdAndAndAuthor(7,"迅哥儿");
        List<Book> bs2 = bookJpaService.getBooksByAuthorStartingWith("草");
        List<Book> bs3 = bookJpaService.getBookByIdAndAndName(7,"西");
        List<Book> bs4 = bookJpaService.getBooksByPriceGreaterThan(30F);
        Book b = bookJpaService.getMaxIdBook();
        System.out.println("bs1" + bs1);
        System.out.println("bs2" + bs2);
        System.out.println("bs3" + bs3);
        System.out.println("bs4" + bs4);
        System.out.println("b" + b);
    }

    @GetMapping("/save")
    public void save(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("迅哥儿");
        book.setName("呐喊");
        book.setPrice(25F);
        bookJpaService.addBook(book);
    }
}

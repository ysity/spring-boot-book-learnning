package org.sang.controller;

import org.sang.domain.Book;
import org.sang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/bookOps")
    public void bookOps(){
        Book book1 = new Book();
        book1.setName("西厢记");
        book1.setAuthor("王师傅");
        int i = bookService.addBook(book1);
        System.out.println("addBook>>>" + i);
        Book book2 = new Book();
        book2.setId(1);
        book2.setName("朝花夕拾");
        book2.setAuthor("迅哥儿");
        int deleteBook = bookService.deleteBookById(3);
        System.out.println("deleteBook>>>"+deleteBook);
        int updateBook = bookService.updateBook(book2);
        System.out.println("updateBook>>>"+ updateBook);
        Book book3 = bookService.getBookById(1);
        System.out.println("book3>>"+book3.toString());
        List<Book> books = bookService.getAllBooks();
        System.out.println("books>>>" + books);
    }
}

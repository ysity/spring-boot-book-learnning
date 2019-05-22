package org.sang.service;

import org.sang.dao.BookJpaDao;
import org.sang.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookJpaService {
    @Autowired
    private BookJpaDao bookJpaDao;

    public void addBook(Book book){
        bookJpaDao.save(book);
    }

    public Page<Book> getBookByPage(Pageable pageable){
        return bookJpaDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author){
        return bookJpaDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceGreaterThan(Float price){
        return bookJpaDao.getBooksByPriceGreaterThan(price);
    }

    public Book getMaxIdBook(){
        return bookJpaDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAndAuthor(Integer id,String author){
        return bookJpaDao.getBookByIdAndAndAuthor(id,author);
    }

    public List<Book> getBookByIdAndAndName(Integer id,String name){
        return bookJpaDao.getBookByIdAndAndName(id,name);
    }
}

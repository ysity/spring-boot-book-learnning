package org.sang.dao;

import org.sang.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookJpaDao extends JpaRepository<Book,Integer> {
    List<Book> getBooksByAuthorStartingWith(String author);
    List<Book> getBooksByPriceGreaterThan(Float price);
    @Query(value = "select * from t_book where id = {select max(id) from t_book}",nativeQuery = true)
    Book getMaxIdBook();

    /*@Param  使用报错  todo*/
    @Query(value = "select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBookByIdAndAndAuthor(@Param("id") Integer id,@Param("author") String author);
    @Query(value = "select b from t_book b where b.id>:id and b.author like %?1% ")
    List<Book> getBookByIdAndAndName(Integer id,String name);

}

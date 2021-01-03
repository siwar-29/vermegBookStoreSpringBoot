package com.vermeg.bookstore.dao;

import java.util.List;
import java.util.Optional;

import com.vermeg.bookstore.dao.entity.Book;

public interface IBookDao {

    List<Book>getAllBooks();

    Book addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Long id);

    boolean deleteBook(Book book);
    

    
    Optional<Book> findById(Long id);

}

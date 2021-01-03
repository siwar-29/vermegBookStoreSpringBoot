package com.vermeg.bookstore.service;

import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dto.BookDto;
import com.vermeg.bookstore.dto.BookDtoAdd;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    Book add(Book book);

    boolean update(Book book);

    boolean deleteById(Long id);

    boolean deleteByBook(Book book);
    
    float calcul (float price);

    Book findById(Long id);

    List<BookDto> getAll();

    BookDto add(BookDtoAdd bookDtoAdd);
}

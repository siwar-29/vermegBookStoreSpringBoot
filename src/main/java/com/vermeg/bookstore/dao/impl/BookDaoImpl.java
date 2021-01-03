package com.vermeg.bookstore.dao.impl;

import com.vermeg.bookstore.dao.IBookDao;
import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dao.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements IBookDao {

    @Autowired
     BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)) {
        	bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean updateBook(Book book) {
        if(bookRepository.save(book)!=null)
        return true;
        else
            return false;
    }



    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

	@Override
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

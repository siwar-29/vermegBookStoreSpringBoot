package com.vermeg.bookstore.service.impl;

import com.vermeg.bookstore.dao.IBookDao;
import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dto.BookDto;
import com.vermeg.bookstore.dto.BookDtoAdd;
import com.vermeg.bookstore.mapper.BookMapper;
import com.vermeg.bookstore.service.IBookService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book add(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean deleteById(Long id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public boolean deleteByBook(Book book) {
        return bookDao.deleteBook(book);
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookDao.findById(id);
        return bookOptional.orElseThrow(() ->
                new EntityNotFoundException("Book not found with id: " + id));
    }

    @Override
    public List<BookDto> getAll() {

        List<Book> allbooks = bookDao.getAllBooks();

        return bookMapper.entityToDtoList(allbooks);
    }

    @Override
    public BookDto add(BookDtoAdd bookDtoAdd) {
        Book book = bookMapper.dtoToEntity(bookDtoAdd);
        Book resultEntity = bookDao.addBook(book);
        return bookMapper.entityToDto(resultEntity);
    }

	@Override
	public float calcul(float price) {
		// TODO Auto-generated method stub
		
		 List<Book> allbooks = bookDao.getAllBooks();
		     price = 0;
		        for (Book var : allbooks)
		        {
		            price+=var.getPrice();
		        }
		    return price;
	}
	

}

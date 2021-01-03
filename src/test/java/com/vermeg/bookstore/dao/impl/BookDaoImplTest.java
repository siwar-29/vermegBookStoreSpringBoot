package com.vermeg.bookstore.dao.impl;

import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dao.impl.BookDaoImpl;
import com.vermeg.bookstore.dao.repository.BookRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author siwar.dandana created on 25-Dec-20 - 21:14
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class BookDaoImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookDaoImpl bookDao;

    @Test
    public void getAllBooks() {
        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");
        Mockito.when((bookRepository.findAll())).thenReturn(Arrays.asList(book));
        assertEquals(book, bookDao.getAllBooks().get(0));
    }

    @Test
    public void addClient() {

        //client to saved : with id = null
        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        //client saved with auto generated id
        Book savedBook = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Mockito.when((bookRepository.save(any(Book.class)))).thenReturn(savedBook);

        assertEquals(savedBook, bookDao.addBook(book));
    }

    @Test
    public void updateBook() {

        Book bookToUpdate = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Book updatedBook = new Book (101L, "hello", "adel", 120.3f , "2028-01-01");

        Mockito.when((bookRepository.save(any(Book.class)))).thenReturn(bookToUpdate);

        assertEquals(bookToUpdate, bookDao.addBook(updatedBook));
    }

    @Test
    public void deleteBook() {

        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        /**
         *  method deleteClient use id as param to delete client by id : in this method we use existById
         *  to check if the id exist in the database , if true we call delete client by id
         */

        Mockito.when(bookRepository.existsById(any(Long.class))).thenReturn(true);

        bookDao.deleteBook(book.getId());

        Mockito.verify(bookRepository).deleteById(book.getId());

//        assertEquals(clientToUpdate,clientDao.addClient(updatedClient));
    }

    @Test
    public void deleteBookt1() {
    }

    @Test
    public void findById() {
        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Mockito.when((bookRepository.findById(any(Long.class)))).thenReturn(Optional.of(book));

        assertEquals(book, bookDao.findById(book.getId()).get());
    }
}
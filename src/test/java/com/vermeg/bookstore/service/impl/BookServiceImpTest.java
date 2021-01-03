package com.vermeg.bookstore.service.impl;

import com.vermeg.bookstore.dao.IBookDao;
import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.service.impl.BookServiceImp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author siwar.dandana created on 25-Dec-20 - 23:32
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceImpTest {

    @Mock
    private IBookDao bookDao;

    @InjectMocks
    private BookServiceImp bookService;

    @Test
    public void getAllBooks() {

      Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Mockito.when(bookDao.getAllBooks()).thenReturn(Arrays.asList(book));

        Assert.assertEquals(1, bookService.getAllBooks().size());
    }

    @Test
    public void add() {

    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
        Book book  =new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Mockito.when(bookDao.deleteBook(any(Long.class))).thenReturn(true);
        Assert.assertTrue(bookService.deleteById(book.getId()));
    }

    @Test
    public void deleteByBook() {
    }

    @Test
    public void findById() {
        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Mockito.when(bookDao.findById(any(Long.class))).thenReturn(Optional.of(book));
        Assert.assertEquals(book, bookService.findById(book.getId()));
    }
}
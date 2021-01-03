package com.vermeg.bookstore.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.service.IBookService;

/**
 * @author siwar.dandana created on 26-Dec-20 - 21:54
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
	
	@MockBean
    private IBookService bookService;

    @Test
    void getBooks() throws Exception {

        List<Book> bookList = Arrays.asList(
        		new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01"),
        		new Book (101L, "hello", "adel", 120.3f , "2028-01-01") );

        when(bookService.getAllBooks()).thenReturn(bookList);

        mockMvc.perform(get("/book/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(101)))
                .andExpect(jsonPath("$.[1].id", is(102)))
                .andExpect(jsonPath("$.[0].title", is("siwar")))
                .andExpect(jsonPath("$.[1].title", is("hello")))
        ;

    }

    @Test
    void getBook() throws Exception {
        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        when(bookService.findById(any(Long.class))).thenReturn(book);

        //URL : localhost:9000/book/client/find?id=101

        mockMvc.perform(get("/book/get").param("id", "101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(101)))
                .andExpect(jsonPath("$.title", is("siwar")))
        ;
    }

    @Test
    void addBook() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Book book = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        Book savedBook = new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");

        when(bookService.add(any(Book.class))).thenReturn(savedBook);

        //URL : localhost:9000/book/client/add

        //mapper.writeValueAsString: to transform client object to json format
        mockMvc.perform(post("/book/add").content(mapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(101)))
                .andExpect(jsonPath("$.title", is("siwar")))
        ;
    }

    @Test
    void deleteBook() throws Exception {

        when(bookService.deleteById(any(Long.class))).thenReturn(true);

        //URL : localhost:9000/book/book/remove?id=101

        mockMvc.perform(delete("/book/remove").param("id", "101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)))
        ;
    }

}
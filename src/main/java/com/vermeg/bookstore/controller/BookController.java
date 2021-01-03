package com.vermeg.bookstore.controller;

import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dao.repository.BookRepository;
import com.vermeg.bookstore.dto.BookDto;
import com.vermeg.bookstore.dto.BookDtoAdd;
import com.vermeg.bookstore.service.IBookService;
import com.vermeg.bookstore.service.impl.BookServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/")
    public List<Book> getClients(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getbook")
    public Book getBook(@RequestParam Long id){
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.add(book);
    }

    @DeleteMapping("/remove")
    public boolean deleteBookt(@RequestParam Long id){
        return bookService.deleteById(id);
    }

    @PutMapping("/update")
    public boolean updateBook(@RequestBody Book book){
        return bookService.update(book);
    }

    @GetMapping("/all")
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping("/add_dto")
    public BookDto addBookDto(@RequestBody BookDtoAdd bookDtoAdd){
        return bookService.add(bookDtoAdd);
    }
    
    @GetMapping("/allprices")
    public List<Book> calculatePrice() {
    	return bookService.getAllBooks();
    
    }

}

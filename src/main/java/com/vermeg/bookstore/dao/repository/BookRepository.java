package com.vermeg.bookstore.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.bookstore.dao.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

   Book findByAuthor(String author);
}

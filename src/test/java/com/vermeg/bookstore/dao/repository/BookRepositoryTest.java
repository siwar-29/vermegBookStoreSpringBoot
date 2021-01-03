package com.vermeg.bookstore.dao.repository;

import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dao.repository.BookRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author siwar.dandana created on 25-Dec-20 - 20:50
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void setUp() {
        // set default data to use in all test methods
        Book book =new Book (101L, "siwar", "les miserables", 12.3f , "2021-01-01");
        testEntityManager.merge(book);
    }

    @Test
    public void findByAuthor() {
        Book bookEntity = bookRepository.findByAuthor("siwar");
        assertThat(bookEntity.getAuthor()).isEqualTo("siwar");
    }
}
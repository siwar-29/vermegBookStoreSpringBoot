package com.vermeg.bookstore.mapper;

import com.vermeg.bookstore.dao.entity.Book;
import com.vermeg.bookstore.dto.BookDto;
import com.vermeg.bookstore.dto.BookDtoAdd;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author siwar.dandana created on 26-Dec-20 - 11:12
 */
@Component
public class BookMapper {

    @Autowired
    private  ModelMapper mapper;

    public  BookDto entityToDto(Book book){

       /* return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .build();*/
       return mapper.map(book,BookDto.class);
    }
    public  List<BookDto> entityToDtoList(List<Book> booksEntity){

        return booksEntity.stream()
                .map(book -> entityToDto(book)).collect(Collectors.toList());

    }

    public  List<BookDto> entityToDtoList2(List<Book> booksEntity){

        return booksEntity.stream()
                .map(book -> entityToDto(book)).collect(Collectors.toList());
    }



    public  Book dtoToEntity(BookDtoAdd dto){
        Book book=new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setReleaseDate(dto.getReleaseDate());

        return book;
    }


}

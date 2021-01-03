package com.vermeg.bookstore.dto;

import lombok.*;

/**
 * @author siwar.dandana created on 26-Dec-20 - 11:12
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private Long id;

    private String title;
    private String author;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
    
}

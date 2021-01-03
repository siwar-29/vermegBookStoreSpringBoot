package com.vermeg.bookstore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

//import javax.persistence.Entity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;
    private float price;
    private String releaseDate;

    


	public Book() {
		super();
	}



	public Book(Long id, String title, String author, float price, String releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
	}



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



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String date) {
		this.releaseDate = date;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", releaseDate="
				+ releaseDate + "]";
	}

	
}

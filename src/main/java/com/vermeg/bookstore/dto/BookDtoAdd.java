package com.vermeg.bookstore.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @author siwar.dandana created on 26-Dec-20 - 11:23
 */
@Data
@Builder
public class BookDtoAdd {

	  private String title;

	    private String author;
	    private float price;
	    private String releaseDate;



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



		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
}
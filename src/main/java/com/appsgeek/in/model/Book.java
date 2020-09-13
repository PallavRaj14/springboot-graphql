package com.appsgeek.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Book")
public class Book {

	@Id
    @Column(name = "isn")
	private String isn;
	private String title;
	private String publisher;
	private String[] authors;
	private String publishedDate;

	public Book() {}

	public Book(String isn, String title, String publisher, String[] authors, String publishedDate) {
		this.isn = isn;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.publishedDate = publishedDate;
	}

	public String getIsn() {
		return isn;
	}

	public void setIsn(String isn) {
		this.isn = isn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

}

package com.book.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@SequenceGenerator(name = "bookserial", initialValue = 500)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookserial")
	private Integer bookId;
	
	private String authorName;
	
	private String logo;
	
	@Column(length=300)
	@NotBlank(message = "Book title cannot be blank")
	private String title;
	
	@NotBlank(message = "Category cannot be blank")
	private String category;
	
	private Double price;
	
	
	@NotBlank(message = "Publisher cannot be blank")
	private String publisher;
	
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date publishedDate;
	
	@Column(length=300)
	private String content;
	
	private boolean bookStatus;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Book(Integer bookId, String authorName, String logo,
			@NotBlank(message = "Book title cannot be blank") String title,
			@NotBlank(message = "Category cannot be blank") String category, Double price,
			@NotBlank(message = "Publisher cannot be blank") String publisher, Date publishedDate, String content,
			boolean bookStatus) {
		super();
		this.bookId = bookId;
		this.authorName = authorName;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.bookStatus = bookStatus;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", authorName=" + authorName + ", logo=" + logo + ", title=" + title
				+ ", category=" + category + ", price=" + price + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", content=" + content + ", bookStatus=" + bookStatus + "]";
	}

	
	
}

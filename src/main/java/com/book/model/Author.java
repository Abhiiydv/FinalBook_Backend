package com.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer AuthorId;
	
	private String authorName;
	
	@Column(unique=true)
	@Email
	private String authorEmail;
	
	@NotNull
	@Size(max=8 , min=5)
	private String authorPassword;

	public Integer getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Integer authorId) {
		AuthorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getAuthorPassword() {
		return authorPassword;
	}

	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}

	public Author(Integer authorId, String authorName, String authorEmail, String authorPassword) {
		super();
		AuthorId = authorId;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.authorPassword = authorPassword;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
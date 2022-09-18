package com.book.service;

import java.util.Optional;

import com.book.model.Author;

public interface IAuthorService {

	
	Integer createAuthor(Author a);
	
	//boolean loginAuth(String email, String password);
	
	Optional<Author> findByEmail(String authorEmailemail);
	
}


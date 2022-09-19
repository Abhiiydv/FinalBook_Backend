package com.book.service;

import java.util.Optional;

import com.book.model.Author;

public interface IAuthorService {


	Integer createAuthor(Author a);

	

	Optional<Author> findByEmail(String authorEmailemail);

}


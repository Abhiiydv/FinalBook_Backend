package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.model.Author;

public interface IAuthorRepository extends JpaRepository<Author,Integer> {

	@Query
	("Select a from Author a where a.authorEmail=?1")
	Author findByEmail(String authorEmail);

}


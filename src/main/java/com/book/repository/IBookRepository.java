package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.model.Book;

public interface IBookRepository extends JpaRepository <Book, Integer> {

	@Query("SELECT p from Book p where " + 
			"p.category LIKE CONCAT('%',:query,'%')"+
			"Or p.publisher LIKE CONCAT('%',:query,'%')"+
			"Or p.authorName LIKE CONCAT('%',:query,'%')"+
			"Or p.title LIKE CONCAT('%',:query,'%')"+
			"Or p.price LIKE CONCAT('%',:query,'%')")
	List<Book> searchBooks(String query);

}

package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.model.Author;
import com.book.model.Book;


public interface IBookService {

	//get all books
	public List<Book> getAllBooks();
	
	//get a book by book id
	Optional <Book> getbookbyid(Integer id);

	//public List<Book> getAllBooksByAuthorId(Integer id);

	
	//add a book
	Integer saveBook2(Book book);
	
	//search books by query
	public List<Book> searchbooks(String query);

	//search books by category
	List<Book> searcBooksbyCategory(String category);
	
	//search books by author name
	List<Book>  searcBooksbyAuthorname(String authorName);
	
	//get books by publisher name
	List<Book>  searcBooksbyPublisherName(String publisherName);
	
	//get all active books
	List<Book> searchActiveBooks();
	
	//delete a book by bookId
	public void deleteBook(Integer id);
	
	//update a book
	public Book updateBook(Integer bookId, Book book);
}

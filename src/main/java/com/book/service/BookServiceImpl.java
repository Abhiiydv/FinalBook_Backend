package com.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exception.ResourceNotFoundException;
import com.book.model.Author;
import com.book.model.Book;
import com.book.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private IBookRepository booksRepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		
		return booksRepository.findAll();
	}

	@Override
	public Optional<Book> getbookbyid(Integer id) {
		// TODO Auto-generated method stub
		return booksRepository.findById(id);
	}

	
	/*
	 * * @Override public List<Book> getAllBooksByAuthorId(Author id) { // TODO
	 * Auto-generated method stub List<Book> li2=
	 * booksRepository.findAll().stream().filter(a->
	 * a.getAuthorId()==id).collect(Collectors.toList());
	 * 
	 * return li2; }
	 */
	 

	@Override
	 public Integer saveBook2(Book book) {
		Book savedBook =  booksRepository.save(book);
		return savedBook.getBookId();
	}

	@Override
	public List<Book> searcBooksbyCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> lis = booksRepository.findAll();
		return lis.stream().filter(a->a.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		
	}
	

	@Override
	public List<Book> searcBooksbyPublisherName(String publisherName) {
		// TODO Auto-generated method stub
		List<Book> liss = booksRepository.findAll();
		return liss.stream().filter(p->p.getPublisher().equalsIgnoreCase(publisherName)).collect(Collectors.toList());
	}


	@Override
	public List<Book> searchActiveBooks() {
		// TODO Auto-generated method stub
		List<Book> list3 = booksRepository.findAll();
		return list3.stream().filter(b->b.isBookStatus()==true).collect(Collectors.toList());
	}

	@Override
	public void deleteBook(Integer id) {
		booksRepository.deleteById(id);
		
	}


	

	

		
		  @Override 
		  public Book updateBook(Integer bookId, Book book) { 
		 
			  Book existingbook = booksRepository.findById(bookId)
						.orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
				existingbook.setTitle(book.getTitle());
				existingbook.setBookStatus(book.isBookStatus());
				existingbook.setPrice(book.getPrice());
				existingbook.setPublisher(book.getPublisher());
				existingbook.setCategory(book.getCategory());
				

				booksRepository.save(existingbook);
				return existingbook;
		  }

		

		@Override
		public List<Book> searcBooksbyAuthorname(String authorName) {
			// TODO Auto-generated method stub
			List<Book> liss = booksRepository.findAll();
			return liss.stream().filter(p->p.getAuthorName().equalsIgnoreCase(authorName)).collect(Collectors.toList());
		}

		@Override
		public List<Book> searchbooks(String query) {
			List<Book> b = booksRepository.searchBooks(query);
			return b;
			
		}
		 
	
}


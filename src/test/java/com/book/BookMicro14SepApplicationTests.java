package com.book;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotBlank;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.book.model.Author;
import com.book.model.Book;
import com.book.repository.IAuthorRepository;
import com.book.repository.IBookRepository;
import com.book.service.AuthorServiceImpl;
import com.book.service.BookServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookMicro14SepApplicationTests {

	@Autowired
	private BookServiceImpl bsimpl;
	
	@Autowired
	private AuthorServiceImpl auimpl;
	
	@MockBean
	private IAuthorRepository aurepo;
	
	@MockBean
	private IBookRepository bookrepo;
	
	@Test
	public void createAuthorTest() {
		Author au = new Author(101, "Author", "author@gmail.com", "null");
		when(aurepo.save(au)).thenReturn(au);
		assertEquals(au.getAuthorId(), auimpl.createAuthor(au));
	}
	
	@Test
	public void saveBook2Test() {
		Book b = new Book(
				111,
				"Ruchi",
		    	"images.jpeg",
				"Wings Of Fire",
		   	 "Comic",
		    	800.50,
		     "Delhi House",
			 new Date(14-30-0006),
			"Just for testing! ",
				 true);
		when(bookrepo.save(b)).thenReturn(b);
		assertEquals(b.getBookId(), bsimpl.saveBook2(b));
	}
	
	@Test
	public void getbookbyidTest() {
		Integer id = 111;
		Optional<Book> b = Optional.ofNullable(new Book(200,
				"Abhi",
		    	"images.jpeg",
				"Ironman",
		   	 "Comic",
		    	1700.00,
		     "Delhi House",
		     new Date(14-30-0006),
			"Just for testing! ",
				 true));
		when(bookrepo.findById(id)).thenReturn(b);
		assertEquals(b,bsimpl.getbookbyid(id));
	}
	@Test
	public void getAllBooksTest() {
		when(bookrepo.findAll()).thenReturn(Stream.of(new Book (201,
				"Tester1",
		    	"images.jpeg",
				"Ironman",
		   	 "Comic",
		    	1750.00,
		     "Delhi House",
		     new Date(14-30-0006),
			"Just for testing! ",
				 true), new Book(202,
							"Tester2",
					    	"images.jpeg",
							"Ironman",
					   	 "Comic",
					    	1800.50,
					     "Delhi House",
					     new Date(14-30-0006),
						"Just for testing! ",
							 true)).collect(Collectors.toList()));
		assertEquals(2,bsimpl.getAllBooks().size());
	}

}

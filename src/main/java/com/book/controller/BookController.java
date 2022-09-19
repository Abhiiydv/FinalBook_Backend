package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.book.model.Book;
import com.book.service.IBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BookController {


	@Autowired
	IBookService bookservice;


	@GetMapping("/test")
	public String greetings() {
		return "Hello Book world!";
	}

	/*
	 * @PostMapping("/savebook") public ResponseEntity<Book> createBook(@RequestBody
	 * Book book){ return new
	 * ResponseEntity<Book>(this.bookservice.saveBook2(book),HttpStatus.CREATED); }
	 */


	private static String UPLOADED_FOLDER = System.getProperty("user.dir")+File.separator+"//src//main//resources";
	@Autowired
	IBookService booksservice;

	@PostMapping("/savebook")
	public Integer saveBook(@RequestParam("bookstring") String book,@RequestParam("image") MultipartFile file) throws JsonMappingException, JsonProcessingException {

		if (file.isEmpty()) {

		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths
					.get(UPLOADED_FOLDER + File.separator + "images" + File.separator + file.getOriginalFilename());
			Files.write(path, bytes);


		} catch (IOException e) {
			e.printStackTrace();
		}

		Book bookobj=new ObjectMapper().readValue(book, Book.class);
		bookobj.setLogo(file.getOriginalFilename());
		return bookservice.saveBook2(bookobj);
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> download(@RequestParam("image") String image) throws IOException {
		//   File file = new File(SERVER_LOCATION + File.separator + image + EXTENSION);
		File file=new File(UPLOADED_FOLDER+ File.separator + "images" +File.separator + image);

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		return ResponseEntity.ok()
				.headers(header)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(resource);
	}



	@GetMapping("/books") 
	public List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Optional<Book> getbookbyid(@PathVariable Integer id){
		Optional<Book> au =  bookservice.getbookbyid(id);
		return au;

	}

	@GetMapping("/books/category/{category}")
	public List<Book> searchBooks(@RequestParam("category") String category){
		return bookservice.searcBooksbyCategory(category);
	}


	@GetMapping("/books/author/{authorName}") public List<Book>
	searchBooks2(@RequestParam("authorName") String authorName){ return
			bookservice.searcBooksbyAuthorname(authorName); }

	@GetMapping("/books/publisher/{publisherName}")
	public List<Book> searchBooks3(@RequestParam("publisherName") String publisherName){
		return bookservice.searcBooksbyPublisherName(publisherName);
	}

	@GetMapping("/books/active")
	public List<Book> ssearchBooks4(){
		return bookservice.searchActiveBooks();
	}

	@GetMapping("/searchbooks")
	public List<Book> searchbooksbyanything(@RequestParam("query") String query){
		return bookservice.searchbooks(query);
	}


	@DeleteMapping("/books/delete/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Integer id) {
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			bookservice.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}


	@PutMapping("books/update/{bookId}")
	public ResponseEntity<Book> updateBookById(@PathVariable("bookId") Integer bookId, @RequestBody Book book){
		return new ResponseEntity<Book>(this.bookservice.updateBook(bookId, book),HttpStatus.OK);
	}

}

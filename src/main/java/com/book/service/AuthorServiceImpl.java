package com.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Author;
import com.book.repository.IAuthorRepository;

@Service
public class AuthorServiceImpl implements IAuthorService {

	
	@Autowired
	private IAuthorRepository authorrepo;
	
	
	@Override
	public Integer createAuthor(Author a) {
		// TODO Auto-generated method stub
		Author savedAuthor = authorrepo.save(a);
		return savedAuthor.getAuthorId();
	}


	@Override
	public Optional<Author> findByEmail(String authorEmail) {
		// TODO Auto-generated method stub
		Author a = authorrepo.findByEmail(authorEmail);
		return Optional.ofNullable(a);
	}


	/*
	 * @Override public boolean loginAuth(String email, String password) { // TODO
	 * Auto-generated method stub Author a =
	 * authorrepo.findAll().stream().filter(a->a.getAuthorEmail().equalsIgnoreCase(
	 * email));
	 * 
	 * return false; }
	 */
}
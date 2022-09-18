package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Author;
import com.book.service.IAuthorService;
import com.google.common.base.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class AuthorController {

	@Autowired
	private IAuthorService auServ;
	
	
	@PostMapping("/create-author")
	Integer registerAuthor(@RequestBody Author a)
	{
		Integer i = auServ.createAuthor(a);
		return i;
	}
	
	@PostMapping("/login")
		
	Author	login(@RequestBody Author a)
		{
			
	 
		java.util.Optional<Author> o =  auServ.findByEmail(a.getAuthorEmail());
			
		if(o.isPresent()) {
			Author au = o.get();
			if(au.getAuthorPassword().equals(a.getAuthorPassword()))
				return au;
		}
			
			return null;
		}
		
	}
	
	


 
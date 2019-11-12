package com.sriman2kl.springframework5.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sriman2kl.springframework5.model.Author;
import com.sriman2kl.springframework5.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@RequestMapping(value="/authors")
	public List<Author> getListOfAuthors(Model model){
		return  (List<Author>) authorRepository.findAll();
		
	}

}

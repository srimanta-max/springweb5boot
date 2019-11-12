package com.sriman2kl.springframework5.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sriman2kl.springframework5.model.Book;
import com.sriman2kl.springframework5.repositories.BookRepositories;


@Controller
public class BookController {
	
	private BookRepositories bookRepository;
	
	public BookController(BookRepositories bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(value="/books")
	public String getBooks(Model model){
		List<Book> all = (List<Book>) bookRepository.findAll();
		//System.out.println(Arrays.toString(all.toArray()));
		 model.addAttribute("books", bookRepository.findAll());
		return "books";
	}

}

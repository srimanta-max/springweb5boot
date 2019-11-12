package com.sriman2kl.springframework5.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sriman2kl.springframework5.model.Author;
import com.sriman2kl.springframework5.model.Book;
import com.sriman2kl.springframework5.model.Publisher;
import com.sriman2kl.springframework5.repositories.AuthorRepository;
import com.sriman2kl.springframework5.repositories.BookRepositories;
import com.sriman2kl.springframework5.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authRepository;
	private BookRepositories bookRepsitory;
	private PublisherRepository publisherRepository;
	
	
	
	public DevBootStrap(AuthorRepository authRepository, BookRepositories bookRepsitory, PublisherRepository publisherRepository) {
		this.authRepository = authRepository;
		this.bookRepsitory = bookRepsitory;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		init();		
	}
	
	public void init(){
		Publisher self = new Publisher("Self","NotYet");
		publisherRepository.save(self);
		
		Publisher sajha = new Publisher("Sajha","Nepal");
		publisherRepository.save(sajha);

		
		
		Author simanta = new Author("Simanta","Lamichhane");
		Book simantaBoook = new Book("jiwan sataha","6192812bpk",self);
		simanta.getBookset().add(simantaBoook);
		simantaBoook.getAuthors().add(simanta);
		simantaBoook.setPublisher(self);

		authRepository.save(simanta);
		bookRepsitory.save(simantaBoook);
		
		
		Author baburam = new Author("Baburam","Lamichhane");
		Book pakhako = new Book("pakhako","7748stu6476",sajha);
		
		pakhako.setPublisher(sajha);
		baburam.getBookset().add(pakhako);
		pakhako.getAuthors().add(baburam);

		authRepository.save(baburam);
		bookRepsitory.save(pakhako);
		
	
	}

}

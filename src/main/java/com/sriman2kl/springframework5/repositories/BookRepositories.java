package com.sriman2kl.springframework5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sriman2kl.springframework5.model.Book;

@Repository
public interface BookRepositories extends CrudRepository<Book, Long> {

}

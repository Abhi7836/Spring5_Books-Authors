package com.example.spring5_booksauthors.repositories;

import com.example.spring5_booksauthors.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}

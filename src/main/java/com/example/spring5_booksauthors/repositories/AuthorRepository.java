package com.example.spring5_booksauthors.repositories;

import com.example.spring5_booksauthors.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}

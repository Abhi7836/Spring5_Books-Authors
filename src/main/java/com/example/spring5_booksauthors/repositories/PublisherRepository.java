package com.example.spring5_booksauthors.repositories;

import com.example.spring5_booksauthors.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}

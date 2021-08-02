package com.example.spring5_booksauthors.bootstrap;

import com.example.spring5_booksauthors.domain.Author;
import com.example.spring5_booksauthors.domain.Book;
import com.example.spring5_booksauthors.repositories.AuthorRepository;
import com.example.spring5_booksauthors.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author abhi = new Author("Abhi","naikk");
        Book udemy=new Book("spring udemy","123123");
        abhi.getBooks().add(udemy);
        udemy.getAuthors().add(abhi);

        authorRepository.save(abhi);
        bookRepository.save(udemy);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}

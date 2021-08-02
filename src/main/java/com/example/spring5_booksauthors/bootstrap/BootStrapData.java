package com.example.spring5_booksauthors.bootstrap;

import com.example.spring5_booksauthors.domain.Author;
import com.example.spring5_booksauthors.domain.Book;
import com.example.spring5_booksauthors.domain.Publisher;
import com.example.spring5_booksauthors.repositories.AuthorRepository;
import com.example.spring5_booksauthors.repositories.BookRepository;
import com.example.spring5_booksauthors.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher =new Publisher();
        publisher.setName("Abhi publishing");
        publisher.setCity("HYD");
        publisher.setState("TS");
        publisher.setPin("501301");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author abhi = new Author("Abhi","naikk");
        Book udemy=new Book("spring udemy","123123");
        abhi.getBooks().add(udemy);
        udemy.getAuthors().add(abhi);

        udemy.setPublisher(publisher);
        publisher.getBooks().add(udemy);

        authorRepository.save(abhi);
        bookRepository.save(udemy);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}

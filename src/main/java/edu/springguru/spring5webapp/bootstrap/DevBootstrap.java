package edu.springguru.spring5webapp.bootstrap;

import edu.springguru.spring5webapp.model.Author;
import edu.springguru.spring5webapp.model.Book;
import edu.springguru.spring5webapp.model.Publisher;
import edu.springguru.spring5webapp.repository.AuthorRepository;
import edu.springguru.spring5webapp.repository.BookRepository;
import edu.springguru.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //First
        Author a1 = new Author("fn1", "ln1");
        Publisher p1 = new Publisher("pubname1", "pubaddress1");
        Book b1 = new Book("title1", "isbn1", p1);
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        authorRepository.save(a1);
        publisherRepository.save(p1);
        bookRepository.save(b1);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher hc = new Publisher("Harper Collins", "some addr");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(hc);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("wrox", "wroxaddress");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(wrox);
        bookRepository.save(noEJB);

    }


}

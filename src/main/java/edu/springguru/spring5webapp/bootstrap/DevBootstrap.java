package edu.springguru.spring5webapp.bootstrap;

import edu.springguru.spring5webapp.model.Author;
import edu.springguru.spring5webapp.model.Book;
import edu.springguru.spring5webapp.repository.AuthorRepository;
import edu.springguru.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //First
        Author a1 = new Author("fn1", "ln1");
        Book b1 = new Book("title1", "isbn1", "publisher1");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        authorRepository.save(a1);
        bookRepository.save(b1);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }


}

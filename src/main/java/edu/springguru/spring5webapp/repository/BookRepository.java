package edu.springguru.spring5webapp.repository;

import edu.springguru.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

package edu.springguru.spring5webapp.repository;

import edu.springguru.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

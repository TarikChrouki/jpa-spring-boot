package com.chrouki.jpaspringboot.dao;

import com.chrouki.jpaspringboot.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Tarik Chrouki on 19/12/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthor(String author);
}

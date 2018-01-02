package com.chrouki.jpaspringboot;

import com.chrouki.jpaspringboot.dao.BookRepository;
import com.chrouki.jpaspringboot.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaSpringBootApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(BookRepository repository) {
		return (args) -> {
			// save some books
			repository.save(new Book("book 1", "ChroukNoriss"));
			repository.save(new Book("book 2", "ChroukNoriss"));
			repository.save(new Book("book 3", "Tarik"));
			repository.save(new Book("book 4", "ChroukNoriss"));

			// fetch all books
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch books by author
			log.info("Book found with findByLastName('ChroukNoriss'):");
			log.info("--------------------------------------------");
			for (Book bauer : repository.findByAuthor("ChroukNoriss")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}

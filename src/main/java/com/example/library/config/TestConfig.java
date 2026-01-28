package com.example.library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.library.model.entities.Book;
import com.example.library.repositories.BookRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book(null, "The Lord of the Rings", "J.R.R. Tolkien");
		Book b2 = new Book(null, "The Art of War", "Sun Tzu");
		
		bookRepository.saveAll(Arrays.asList(b1, b2));
	}
}

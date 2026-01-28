package com.example.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.model.entities.Book;
import com.example.library.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		
		return book.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Book insert(Book book) {
		return bookRepository.save(book);
	}
}

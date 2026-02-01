package com.example.library.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.library.model.entities.Book;
import com.example.library.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> booksList = bookService.findAll();
		
		return ResponseEntity.ok().body(booksList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book book = bookService.findById(id);
		
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<Book> findByTitle(@RequestParam String title) {
		Book book = bookService.findByTitle(title);
		
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping
	public ResponseEntity<Book> insert(@RequestBody Book book) {
		book = bookService.insert(book);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(book.getId())
				.toUri();
		return ResponseEntity.created(uri).body(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package com.example.library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	public Optional<Book> findByTitle(String title);
}

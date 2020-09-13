package com.appsgeek.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsgeek.in.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	

}

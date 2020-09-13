package com.appsgeek.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsgeek.in.service.BookService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("book/store")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult result = bookService.getGraphQL().execute(query);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}

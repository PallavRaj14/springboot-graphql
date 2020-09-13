package com.appsgeek.in.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsgeek.in.model.Book;
import com.appsgeek.in.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String isn = environment.getArgument("id");
		return bookRepository.getOne(isn);
		
	}

}

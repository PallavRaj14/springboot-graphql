package com.appsgeek.in.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsgeek.in.model.Book;
import com.appsgeek.in.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBookDataFetcher implements DataFetcher<List<Book>> {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		return (List<Book>) bookRepository.findAll();
	}

}

package com.appsgeek.in.service;


import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.appsgeek.in.model.Book;
import com.appsgeek.in.repository.BookRepository;
import com.appsgeek.in.service.datafetcher.AllBookDataFetcher;
import com.appsgeek.in.service.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class BookService {
	
	@Value("classpath:books.graphql")
	Resource resource;
	
	private GraphQL graphql;
	
	@Autowired
	private AllBookDataFetcher allBooksDataFetcher;
	
	@Autowired
	private BookDataFetcher bookDataFetcher;
	
	@Autowired
	BookRepository bookRepositiry;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		loadDataIntoHSQL();
		
		File schemaFile= resource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema= new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphql = GraphQL.newGraphQL(schema).build();
	}

	private void loadDataIntoHSQL() {
		Stream.of(
				new Book("1234", "Thor", "UK Publisher", new String[] {"Thor", "Loki"}, "2012/05/14"),
				new Book("2345", "One Night at Call center", "Rupa", new String[] {"Chetan", "Bhagat"}, "2012/05/14"),
				new Book("3456", "5 point someone", "Rupa", new String[] {"Chetan Bhagat"}, "2012/05/14")
				).forEach(book -> bookRepositiry.save(book));
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring->typeWiring
						.dataFetcher("allBooks", allBooksDataFetcher)
						.dataFetcher("book", bookDataFetcher)).build();
	}
	
	public GraphQL getGraphQL() {
		return graphql;
	}
	 
}

# All requests are POST methods
# Request JSON for all books, change request value for other fields.
{
	allBooks{
		isn
		authors
	}
}

# Request JSON for book with id
{
	book(id: "1234"){
		isn
		authors
	}
}
package com.stackroute.springboot.rest.API.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.stackroute.springboot.rest.API.exception.BookNotFoundException;
import com.stackroute.springboot.rest.API.model.Book;

@Service
public class BookService {
	
	 private final AtomicInteger idCounter = new AtomicInteger();
	
	 List<Book> books = new ArrayList<>();

		public List<Book> getAllBooks() {
			// Write code to get all book details
			return books;
		}

		public Optional<Book> getBookById(String id) {

			// Write code to get book details by id

			return books.stream().filter(book -> book.getId().equals(id)).findFirst();

//    	for (Book book : books) {
//            if (book.getId().equals(id)) {
//                return book;
//            }
//        }
//        return null; 
		}


	public Book addBook(Book book) {
		// Write code to add books in the arraylist
		String newId = String.valueOf(idCounter.incrementAndGet());
		book.setId(newId);
		Book newBook = new Book(newId, book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice());

		boolean add = books.add(newBook);
		if (add) {
			return newBook;
		}
		return null;
	}

	public Book updateBook(String id, Book updatedBook) {
		// Write code to update book details

		int index = findBookIndexById(id);

		if (index == -1) {

			throw new BookNotFoundException("non-existent-id");
		}

		// Update the book details at the found index
		Book existingBook = books.get(index);

		System.out.println(existingBook.getId());

		existingBook.setId(updatedBook.getId());
		existingBook.setTitle(updatedBook.getTitle());
		existingBook.setAuthor(updatedBook.getAuthor());
		existingBook.setGenre(updatedBook.getGenre());
		existingBook.setPrice(updatedBook.getPrice());
		return existingBook;

	}
	
	private int findBookIndexById(String id) {

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getId().equals(id)) {

				return i;
			}
		}
		return -1;
	}

	public void deleteBook(String id) {
		// Write code to delete book details by id
		 int index = findBookIndexById(id);

	        if (index == -1) {
	           
	        	throw new BookNotFoundException("non-existent-id");
	        }
		books.removeIf(book -> book.getId().equals(id));
//		if (!books.contains(id)) {
//            throw new BookNotFoundException("non-existent-id");
//        }else {
//        	books.removeIf(book -> book.getId().equals(id));
//		}
		
//		Iterator<Book> iterator = books.iterator();
//		while (iterator.hasNext()) {
//			Book book = iterator.next();
//			if (book.getId().equals(id)) {
//				iterator.remove();
//
//			}
//		}

	}
}

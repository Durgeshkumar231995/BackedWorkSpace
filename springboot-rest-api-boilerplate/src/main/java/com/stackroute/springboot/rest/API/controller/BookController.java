package com.stackroute.springboot.rest.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springboot.rest.API.model.Book;
import com.stackroute.springboot.rest.API.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
       //Write code to get all books
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
    	
    	Optional<Book> book = null;
		try {
			//Write code to get books by ID
			book = bookService.getBookById(id);

			if (book.isPresent() && !book.isEmpty()) {
				return new ResponseEntity<>(book.get(), HttpStatus.OK);
			}
			
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        //Write code to add books
    	Book book2=null;
    	if(book.getId()==null) {
    		 book2 = bookService.addBook(book);
    		 return new ResponseEntity<Book>(book2,HttpStatus.CREATED);
    	}
		return null;
      
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        //Write code to update book details
        return new ResponseEntity<Book>(bookService.updateBook(id, updatedBook),HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable String id) {
		// Write code to delete any book by id
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {
			bookService.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.BookService;

@RestController
@RequestMapping(value="/book")
public class BookController 
{

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable(name = "id") int id)
	{
		return bookService.getBookById(id);
	}
	
	@GetMapping("/category/{id}")
	public List<Book> getByCategory(@PathVariable(name = "id") int id)
	{
		return bookService.getByCategory(id);
	}
	
	@PostMapping("/addnewBook")
	public Book addnewBook(@RequestBody Book book)
	{
		return bookService.addnewBook(book);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable(name = "id") int id,@RequestBody Book book)
	{
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable(name = "id") int id)
	{
		return bookService.deleteBook(id);
	}
	
}

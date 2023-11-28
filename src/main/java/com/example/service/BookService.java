package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.NotFoundException;
import com.example.model.Book;
import com.example.model.Category;
import com.example.repository.BookRepository;
import com.example.repository.CategoryRepository;

@Service
public class BookService 
{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id)
	{
		Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book id "+id+" does not exist."));
		return book;
		
	}
	
	public List<Book> getByCategory(int id)
	{
		
		Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Book id "+id+" does not exist."));
		
		List<Book> books = category.getBook();
		
		return books;
	}
	
	public Book addnewBook(Book book)
	{
		return bookRepository.save(book);
	}
	
	public Book updateBook(int id,Book book)
	{
		Book bookDetails = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book id "+id+" does not exist."));
		
		if(book.getName()!=null)
			bookDetails.setName(book.getName());
		if(book.getAuthor()!=null)
			bookDetails.setAuthor(book.getAuthor());
		if(book.getPublisher()!=null)
		bookDetails.setPublisher(book.getPublisher());
		if(book.getCopies()!=0)
			bookDetails.setCopies(book.getCopies());
		if(book.getCategory()!=null)
			bookDetails.setCategory(book.getCategory());
		
		Book updatedBook = bookRepository.save(bookDetails);
		return updatedBook;
	}
	
	public String deleteBook(int id)
	{
		Book book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book id "+id+" does not exist."));
		String bookName = book.getName();
		bookRepository.delete(book);
		
		return bookName+" book is deleted";
	}
	
}

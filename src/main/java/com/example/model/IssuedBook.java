package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="issuedBook")
public class IssuedBook 
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issue issue;
	

	@Column(name = "returned")
	private Integer returned;


	public IssuedBook(int id, Book book, Issue issue, Integer returned) {
		super();
		this.id = id;
		this.book = book;
		this.issue = issue;
		this.returned = returned;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Issue getIssue() {
		return issue;
	}


	public void setIssue(Issue issue) {
		this.issue = issue;
	}


	public Integer getReturned() {
		return returned;
	}


	public void setReturned(Integer returned) {
		this.returned = returned;
	}


	public IssuedBook() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}

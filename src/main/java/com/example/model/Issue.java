package com.example.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="issue")
public class Issue 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "issueDate")
	private Date issueDate;
	
	@Column(name = "expected_return_date")
	private Date expectedReturnDate;
	
	@Column(name = "returned")
	private Integer returned;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member; 
	
	
	@OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
	private List<IssuedBook> issuedBooks;


	public Issue(int id, Date issueDate, Date expectedReturnDate, Integer returned, Member member,
			List<IssuedBook> issuedBooks) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.expectedReturnDate = expectedReturnDate;
		this.returned = returned;
		this.member = member;
		this.issuedBooks = issuedBooks;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}


	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}


	public Integer getReturned() {
		return returned;
	}


	public void setReturned(Integer returned) {
		this.returned = returned;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public List<IssuedBook> getIssuedBooks() {
		return issuedBooks;
	}


	public void setIssuedBooks(List<IssuedBook> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}


	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

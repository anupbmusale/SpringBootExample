package com.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
	

	public Author(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	public Author(){	
	}
	
	@OneToOne(targetEntity = Book.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
    private Book book;

	public Author(Book book, Long id, String name, String code) {
		this.book = book;
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;

//import com.springboot.error.validator.Author;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@com.springboot.error.validator.Author
	private String author;
	
	/*@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "auth_id", referencedColumnName = "id", nullable = false)
	private Author authObj;*/

	/*public Author getAuth() {
		return authObj;
	}*/

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", authObj=" + /*authObj + */", price=" + price + "]";
	}

	@NotNull(message = "Please provide a price")
	@DecimalMin("1.00")
	private BigDecimal price;

	// avoid this "No default constructor for entity"
	public Book() {
	}
	
	public Book(String name, String author, BigDecimal price) {
		this.name = name;
		this.author = author;
		this.price = price;
	
	}

	/*public Book(String name, String author, BigDecimal price, Author authObj) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.authObj = authObj;
	}*/

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

/*	public Author getAuthObj() {
		return authObj;
	}

	public void setAuthObj(Author authObj) {
		this.authObj = authObj;
	}*/

}

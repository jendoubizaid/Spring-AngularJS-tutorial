package com.insat.jebouquine.repository.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Category {
	@Id
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Book> books;
	
	public Category() {
		super();
		books=new ArrayList<Book>();
	}
	
	public Category(String name) {
		this();
		this.name = name;
	}

	public Category(String name, List<Book> books) {
		this();
		this.name = name;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}

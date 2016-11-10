package com.insat.jebouquine.repository.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id 
	private String isbn;
	private String name;
	private double price;
	@Column(length=1000)
	private String description;
	private String author;
	private String editor;
	@JsonIgnore
	@Lob
	private byte[] photo;
	@JsonIgnore
	@ManyToOne
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Book() {
		super();
	}
	
	public Book(String isbn, String name, double price, String description, String author, String editor) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.description = description;
		this.author = author;
		this.editor = editor;
	}
	public Book(String isbn, String name, double price, String description, String author, String editor, byte[] photo) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.description = description;
		this.author = author;
		this.editor = editor;
		this.photo = photo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", author=" + author + ", editor=" + editor + ", photo=" + Arrays.toString(photo) + ", category="
				+ category + "]";
	}
	
	
}

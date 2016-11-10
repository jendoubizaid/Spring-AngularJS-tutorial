package com.insat.jebouquine.jsonbean;

import com.insat.jebouquine.repository.entities.Book;

public class OrderRaw {
	private Book book;
	private int qte;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
}

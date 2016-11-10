package com.insat.jebouquine.service.facade;

import java.util.List;

import com.insat.jebouquine.repository.entities.Book;

public interface IBookService {
	
	Book findById(String isbn);

//	void saveBook(Book book);
	
	boolean saveBook(Book book,String categoryName);
	
	void deleteBookByIsbn(String isbn);
	
	List<Book> findAllBooks();
	
	void updateBook(Book book);

	public List<Book> getBooksTenByTen(int start,int limit);

	public List<Book> getBooksByCategory(String categoryName);
	
	public List<Book> findByKeyWord(String keyWord);

	public List<Book> findByDetails(String isbn, String name, double price, String author, String editor);

	public List<Book> findBookOrderByName();

	public List<Book> findBookOrderByPrice();

	boolean isBookExist(Book book);
	
}

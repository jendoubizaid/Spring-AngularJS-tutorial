package com.insat.jebouquine.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.repository.entities.Category;
import com.insat.jebouquine.repository.facade.IBookRepository;
import com.insat.jebouquine.repository.facade.ICategoryRepository;
import com.insat.jebouquine.service.facade.IBookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository dao;
	@Autowired
	ICategoryRepository categoryDao;

	@Override
	public Book findById(String isbn) {
		return dao.findById(isbn);
	}

	@Override
	public boolean saveBook(Book book, String categoryName) {
		System.out.println(">>>>>>>>>book service boolean add book");
		Category cat = categoryDao.findById(categoryName);
		if (cat == null) {
			return false;
		} else {
			book.setCategory(cat);
			dao.saveBook(book);
			return true;
		}
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		dao.deleteBookByIsbn(isbn);
	}

	@Override
	public List<Book> findAllBooks() {
		return dao.findAllBooks();
	}

	@Override
	public void updateBook(Book book) {
		Book entity = dao.findById(book.getIsbn());
		if (entity != null) {
			entity.setAuthor(book.getAuthor());
			entity.setDescription(book.getDescription());
			entity.setEditor(book.getEditor());
			entity.setName(book.getName());
			entity.setPhoto(book.getPhoto());
			entity.setPrice(book.getPrice());
		}
	}

	@Override
	public List<Book> getBooksTenByTen(int start, int limit) {
		return dao.getBooksTenByTen(start, limit);
	}

	@Override
	public List<Book> getBooksByCategory(String categoryName) {
		return dao.getBooksByCategory(categoryName);
	}

	@Override
	public List<Book> findByKeyWord(String keyWord) {
		return dao.findByKeyWord(keyWord);
	}

	@Override
	public List<Book> findByDetails(String isbn, String name, double price, String author, String editor) {
		return dao.findByDetails(isbn, name, price, author, editor);
	}

	@Override
	public List<Book> findBookOrderByName() {
		return dao.findBookOrderByName();
	}

	@Override
	public List<Book> findBookOrderByPrice() {
		return dao.findBookOrderByPrice();
	}

	public boolean isBookExist(Book book) {
		Book entity = dao.findById(book.getIsbn());
		if (entity == null)
			return false;
		return true;
	}

//	@Override
//	public void saveBook(Book book) {
//		// TODO Auto-generated method stub
//
//	}

}

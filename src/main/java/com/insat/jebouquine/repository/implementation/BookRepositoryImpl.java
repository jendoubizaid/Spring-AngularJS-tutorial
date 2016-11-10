package com.insat.jebouquine.repository.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.repository.facade.GenericRepository;
import com.insat.jebouquine.repository.facade.IBookRepository;

@Repository("bookDao")
public class BookRepositoryImpl extends GenericRepository<String, Book> implements IBookRepository {

	@Override
	public Book findById(String isbn) {
		return getByKey(isbn);
	}

	@Override
	public void saveBook(Book book) {
		persist(book);
	}

	@Override
	public void deleteBookByIsbn(String isbn) {
		Query query = getSession().createSQLQuery("delete from Book where isbn = :isbn");
		query.setString("isbn", isbn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBooks() {
		Criteria criteria = createEntityCriteria();
		return (List<Book>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksTenByTen(int start, int limit) {
		Query q = getSession().createQuery("from Book");
		q.setFirstResult(start);
		q.setMaxResults(limit);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksByCategory(String categoryName) {
		Query q = getSession().createQuery("select b from Book b JOIN b.category c where c.name=:x ");
		q.setParameter("x", categoryName);
		return q.list();
	}

	@Override
	public List<Book> findByKeyWord(String keyWord) {
		
		List<Book> books = getSession()
				.createQuery(
						"select b from Book b where lower(b.isbn) like lower(:x) or lower(b.name) like lower(:x) or lower(b.author) like lower(:x) ")
				.setParameter("x", "%" + keyWord + "%").list();
		return books;
	}

	@Override
	public List<Book> findByDetails(String isbn, String name, double price, String author, String editor) {
		Criteria criteria = getSession().createCriteria(Book.class);
		if (name.length() > 0)
			criteria.add(Restrictions.like("name", name).ignoreCase());
		if (author.length() > 0)
			criteria.add(Restrictions.like("author", author).ignoreCase());
		if (editor.length() > 0)
			criteria.add(Restrictions.like("editor", editor).ignoreCase());
		if (isbn.length() > 0)
			criteria.add(Restrictions.like("isbn", isbn).ignoreCase());
		return criteria.list();
	}

	@Override
	public List<Book> findBookOrderByName() {
		List<Book> books = getSession().createQuery("select b from Book b order by b.name ").list();
		return books;
	}

	@Override
	public List<Book> findBookOrderByPrice() {
		List<Book> books = getSession().createQuery("select b from Book b order by b.price ").list();
		return books;
	}

	// TODO
	@Override
	public List<Book> findBestSaledBook() {
		Criteria criteria = getSession().createCriteria(Book.class);
		return null;
	}

}

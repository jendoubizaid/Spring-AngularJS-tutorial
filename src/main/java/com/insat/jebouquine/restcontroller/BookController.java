package com.insat.jebouquine.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.insat.jebouquine.jsonbean.BookF;
import com.insat.jebouquine.jsonbean.DetailedSearchBook;
import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.service.facade.IBookService;



@RestController
@RequestMapping("/rest")
public class BookController {

	@Autowired
	IBookService bookService;
	@RequestMapping(value = "/book/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = bookService.findAllBooks();
        if(books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
    //-------------------Retrieve Single Book--------------------------------------------------------
     
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
        System.out.println("Fetching Book with id " + id);
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
 
    //-------------------Retrieve Book By Key Word-----------------------------------------------
     
    
    //-------------------Create a Book--------------------------------------------------------
     
    @RequestMapping(value = "/book/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody BookF book,UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + book.getName());
        Book newBook=new Book(book.getIsbn(), book.getName(), book.getPrice(), book.getDescription(), book.getAuthor(), book.getEditor());
        if (bookService.isBookExist(newBook)) {
            System.out.println("A Book with name " + book.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        boolean bookSaved=bookService.saveBook(newBook,book.getCatName());
        if(bookSaved==false){
        	System.out.println("category with name"+book.getCatName()+"does not exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getIsbn()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @RequestBody Book book) {
        System.out.println("Updating User " + id);
         
        Book currentBook = bookService.findById(id);
         
        if (currentBook==null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
         
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    //------------------- Delete a Book --------------------------------------------------------
     
    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting Book with isbn " + id);
 
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
 
        bookService.deleteBookByIsbn(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
    
    //end crud method
    
    //begin search methods
    @RequestMapping(value = "/book/ByKeyWord/{keyword}", method = RequestMethod.POST)
    public ResponseEntity<List<Book>> searchBooksByKeyWord(@PathVariable("keyword")String keyword) {
    	System.out.println(">>>>>>>>>>>>>>>>search book by keyword");
    	List<Book> books = bookService.findByKeyWord(keyword);
        if(books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/book/ByDetails/", method = RequestMethod.POST)
    public ResponseEntity<List<Book>> searchBooksByDetails(@RequestBody DetailedSearchBook book) {
        System.out.println(">>>>>>>>>>>>>>>>search book by details");
    	List<Book> books = bookService.findByDetails(book.getIsbn(), book.getName(), book.getPrice(), book.getAuthor(), book.getEditor());
        if(books.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
    //get as parameter books isbn and return list books
    @RequestMapping(value ="/listBookById/{listISBN}", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooksById(@PathVariable String[] listISBN) {
        System.out.println(">>>>>>>>>>>list isbn:");
    	for (String string : listISBN) {
			System.out.println(string);
		}
    	List<Book> books=new ArrayList<Book>();
        for (String id : listISBN) {
        	Book book=bookService.findById(id);
        	if(book==null){
        		System.out.println("Book with id " + id + " not found");
                return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        	}
			books.add(book);
		}
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
    @RequestMapping(value ="/BooksByCat/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) {
    	List<Book> books=bookService.getBooksByCategory(category);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
}

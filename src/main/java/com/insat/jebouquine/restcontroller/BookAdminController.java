package com.insat.jebouquine.restcontroller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.Theme;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.insat.jebouquine.jsonbean.BookF;
import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.repository.entities.Category;
import com.insat.jebouquine.service.facade.IBookService;
import com.insat.jebouquine.service.facade.ICategoryService;


@Controller
public class BookAdminController {
	
	@Autowired
	IBookService bookService;
	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping(value="/admin/books")
	public String listBooks(Model model){
		model.addAttribute("books",bookService.findAllBooks());
		return "admin/books";
	}
	
	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		BookF b=new BookF();
		HashMap<String, String>categoryModel=new HashMap<String, String>();
		List<Category>category=(List<Category>) categoryService.findAllCategories();
		for (int i=0;i<category.size();i++) {
			categoryModel.put(category.get(i).getName(), category.get(i).getName());
		}
		
		model.addAttribute("categoriesName",categoryModel);
		model.addAttribute("book", b);
		return "admin/addBook";
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public String saveBook(@Valid BookF bookF, BindingResult br, Model model, MultipartFile file) throws Exception {
		if (br.hasErrors()) {
			return "admin/addBook";
		}
		Book book1 = bookService.findById(bookF.getIsbn());
		if (book1 != null) {
			FieldError error = new FieldError("livre", "ISBN", "le livre existe deja");
			System.out.println(">>>>>>>>>>>>>>>error add book");
			return "admin/addBook";
		}
		Book book=new Book(bookF.getIsbn(),bookF.getName(),bookF.getPrice(),bookF.getDescription(),bookF.getAuthor(),bookF.getEditor());
		if (!file.isEmpty()) {
			book.setPhoto(file.getBytes());
		}
//		Category cat=categoryService.findById(bookF.getCatName());
//		book.setCategory(cat);
		System.out.println(">>>>>>>>>>ajout du livre"+book.getName());
		bookService.saveBook(book,bookF.getCatName());
		System.out.println("ajout d'un livre et redirection");
		return "redirect:/admin/books";
	}

	@RequestMapping(value = "/admin/bookPhoto/{isbn}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(@PathVariable("isbn") String isbn) throws IOException {
		Book book = bookService.findById(isbn);
		if (book.getPhoto() == null) {
			System.out.println("photo null");
			return new byte[0];
		} else {
			System.out.println("photo:" + book.getPhoto());
			return IOUtils.toByteArray(new ByteArrayInputStream(book.getPhoto()));
		}
	}
}

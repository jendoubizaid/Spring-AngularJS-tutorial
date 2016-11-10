package com.insat.jebouquine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String indexPage(){
		return "redirect:/main";
	}
	
	@RequestMapping("/main")
	public String mainPage(){
		return "main";
	}
	@RequestMapping("/partials/books")
	public String partialBooksPage(){
		return "partials/books";
	}
	@RequestMapping("/partials/checkout")
	public String partialCheckoutPage(){
		return "partials/checkout";
	}
	@RequestMapping("/mycategory/")
	public String categoryPage(){
		return "category";
	}
	@RequestMapping("/checkout/")
	public String checkCart(){
		return "checkout";
	}
	@RequestMapping("/partials/addUser")
	public String addUser(){
		return "partials/addUser";
	}
	@RequestMapping("/partials/bookDetails")
	public String detailsBook(){
		return "partials/bookDetails";
	}
	@RequestMapping("/partials/booksByKeyword")
	public String keywordSearchBook(){
		return "partials/booksByKeyword";
	}
	@RequestMapping("/partials/booksByCategory")
	public String booksByCat(){
		return "partials/booksByCategory";
	}
	@RequestMapping("/admin/category")
	public String addCategory(){
		return "admin/category";
	}
	
	
}

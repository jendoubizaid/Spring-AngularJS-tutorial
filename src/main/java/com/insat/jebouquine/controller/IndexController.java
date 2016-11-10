package com.insat.jebouquine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String indexPage(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in index controller");
		return "redirect:/main";
	}
	
	@RequestMapping("/main")
	public String mainPage(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in main page index controller");
		return "main";
	}
	@RequestMapping("/partials/books")
	public String partialBooksPage(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in partial books index controller");
		return "partials/books";
	}
	@RequestMapping("/partials/checkout")
	public String partialCheckoutPage(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in checkout index controller");
		return "partials/checkout";
	}
	@RequestMapping("/mycategory/")
	public String categoryPage(){
		return "category";
	}
	@RequestMapping("/checkout/")
	public String checkCart(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in checkout controller");
		return "checkout";
	}
	@RequestMapping("/partials/addUser")
	public String addUser(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in add user controller");
		return "partials/addUser";
	}
	@RequestMapping("/partials/bookDetails")
	public String detailsBook(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in book details controller");
		return "partials/bookDetails";
	}
	@RequestMapping("/partials/booksByKeyword")
	public String keywordSearchBook(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in book details controller");
		return "partials/booksByKeyword";
	}
	@RequestMapping("/partials/booksByCategory")
	public String booksByCat(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in book details controller");
		return "partials/booksByCategory";
	}
	@RequestMapping("/admin/category")
	public String addCategory(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>im in book details controller");
		return "admin/category";
	}
	
	
}

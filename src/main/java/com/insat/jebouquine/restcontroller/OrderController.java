package com.insat.jebouquine.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insat.jebouquine.jsonbean.Cart;
import com.insat.jebouquine.jsonbean.OrderForm;
import com.insat.jebouquine.jsonbean.OrderRaw;
import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.service.facade.IBookService;
import com.insat.jebouquine.service.facade.IUserService;
import com.insat.jebouquine.service.facade.IOrderService;


@RestController
@RequestMapping("/rest")
public class OrderController {

	@Autowired
	IBookService bookService;
	@Autowired
	IOrderService orderService;
	@Autowired
	IUserService clientService;
	@Secured(value={"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/checkout/", method = RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<List<Book>> getBooksById(@RequestBody OrderForm commandRaws) {
		Cart cart = new Cart();
		User client=clientService.findById((String)loggedUser().get("username"));
		List<Book> books = new ArrayList<Book>();
		for (OrderRaw raw : commandRaws.getOrderRawList()) {
			Book book = bookService.findById(raw.getBook().getIsbn());
			if (book == null) {
				return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
			}
			cart.addItem(book, raw.getQte());
			books.add(book);
		}
		if (client != null) {
			orderService.saveOrder(cart, client, "manzel Tmim");
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	public Map<String, Object>loggedUser(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)){
			String username=auth.getName();
			List<String>roles=new ArrayList<String>();
			for(GrantedAuthority ga:auth.getAuthorities()){
				roles.add(ga.getAuthority());
			}
			Map<String,Object>params=new HashMap<String,Object>();
			params.put("username",username);
			params.put("roles",roles);
			return params;
		}else return new HashMap<String,Object>();
	}

}

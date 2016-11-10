package com.insat.jebouquine.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insat.jebouquine.repository.entities.Role;
import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.service.facade.IUserService;

@RestController
@RequestMapping("/rest")
public class AuthentificationRestController {
	@Autowired
	IUserService userService;
	@RequestMapping("/getLoggedUser")
	public Map<String, Object> getLoggedUser(){
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
	@RequestMapping(value="/addUser/",method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody User user){
		Role role=new Role("USER");
		user.getRoles().add(role);
		userService.saveClient(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
}

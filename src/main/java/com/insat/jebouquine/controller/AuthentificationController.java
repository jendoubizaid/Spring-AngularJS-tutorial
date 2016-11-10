package com.insat.jebouquine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthentificationController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
	@RequestMapping("/partials/login")
	public String restlogin(){
		return "partials/login";
	}
	@RequestMapping("/partials/signup")
	public String restsignup(){
		return "partials/signup";
	}
	
}

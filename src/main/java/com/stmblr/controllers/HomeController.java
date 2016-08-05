package com.stmblr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	
	 @RequestMapping("/access_denied")
	    public String notAuth(){
	        return "access_denied";
	    }

	    @RequestMapping("login")
	    public String loginForm(){
	        return "login";
	    }

}

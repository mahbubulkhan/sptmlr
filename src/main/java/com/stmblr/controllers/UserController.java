/*package com.stmblr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stmblr.domain.User;
import com.stmblr.services.UserService;

@Controller
public class UserController {

	private UserService userservice;

	@Autowired
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@RequestMapping("/login")
	public String userLogin(Model model) {

		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String saveOrUpdateProduct(@Valid User user, BindingResult result) {
		// Post savedPost = userservice.
		// return "redirect:/post/" + savedPost.getId();
		if (result.hasErrors()) {
			
			return "login";
			
		}
		else
		{
			Boolean status = userservice.isValidate(user);
			if (status) {
				return "redirect:/posts";
			} else {
				return "login";
			}
		}
		

	}

}
*/
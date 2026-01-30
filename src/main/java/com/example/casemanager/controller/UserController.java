package com.example.casemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.casemanager.entity.User;
import com.example.casemanager.form.UserRegistForm;
import com.example.casemanager.service.UserService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/user-regist")
	public String registForm(Model model) {
		
		model.addAttribute("userRegistForm", new UserRegistForm());
		
		return "user-regist";
	}
	
	@PostMapping("/user-regist")
	public String regist(@Validated @ModelAttribute
			UserRegistForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "regist";
		}
		
		User user = new User();
		user.setEmail(form.getEmail());
		user.setUserName(form.getUserName());
		user.setPassword(form.getPassword());
		
		userService.regist(user);
		
		return "redirect:/login";
	}
	
	
	
}

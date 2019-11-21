package com.platform.open_house.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.platform.open_house.models.User;
import com.platform.open_house.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = {"/","/login"})
	public String loginPage(Model model) {
		return "Login";
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
		User user = userRepository.loginUser(username, password);
		if(user == null) {
			model.addAttribute("user", user);
			return "Login";
		}
		return "index";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "Registration";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
			System.out.println("firstName: " + user.getFirstName());
			System.out.println("lastName: " + user.getLastName());
			System.out.println("username: " + user.getUsername());
			System.out.println("password: " + user.getPassword());
			System.out.println("location: " + user.getLocation());
			System.out.println("phoneNumber: " + user.getPhoneNumber());
			System.out.println("email: " + user.getEmail());
			System.out.println("birthday: " + user.getBirthday().toString());
		
		if(result.hasErrors()) {
			return "Registration";
		}
			
		Integer id = userRepository.createUser(user);
		
		if(id == -1) {
			model.addAttribute("errorMessage", "Create student failed.");
			return "Registration";
		}
		
		return "Login";
	}
	
	
}

package com.platform.open_house.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			
			return "Login";
		}
		model.addAttribute("userId", user.getUserId());
		return "redirect:/homeWithId/"+user.getUserId();
	}
	
	@GetMapping("/profile/{userId}")
	public String profilePage(@PathVariable Integer userId, Model model) throws SQLException {
		
		User currentUser = userRepository.getUserById(userId);
		
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("user", new User());
		
		return "Profile";
	}
	
	@PostMapping("/updateUser/{userId}")
	public String updateUser(@Valid @ModelAttribute("user") User user,  BindingResult result, @PathVariable Integer userId, @RequestParam String currentPassword, Model model) throws SQLException {
		
		User currentUser = userRepository.getUserById(userId);
		
		if(currentUser.getPassword().equals(currentPassword)) {
			
			if(userRepository.updateUser(user)) {
				return "redirect:/homeWithId/"+ userId;
			}
		}
		
		return "redirect:/profile/"+userId;
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "Registration";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam String confirmPassword, Model model) {
		if(result.hasErrors()) {
			return "Registration";
		}
		
		String username = user.getUsername();
		User existingUser = userRepository.getUserByUsername(username);
		
		if(existingUser != null) {
			model.addAttribute("usernameTakenError", "That username is taken, try another");
			return "Registration";
		}
		
		if(!user.getPassword().equals(confirmPassword)) {
			model.addAttribute("confirmPasswordErrorMessage", "Passwords do not match.");
			return "Registration";
		}
			
		Integer id = userRepository.createUser(user);
		
		if(id == -1) {
			model.addAttribute("errorMessage", "Create user failed.");
			return "Registration";
		}
		
		return "Login";
	}
	
	
}

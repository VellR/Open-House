package com.platform.open_house.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.platform.open_house.models.Item;
import com.platform.open_house.models.Request;
import com.platform.open_house.repositories.RequestRepository;

@Controller
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;
	
	@GetMapping("/request/{userId}")
	public String requestPage(@PathVariable Integer userId, Model model) {
		
		List<Request> requestList = requestRepository.getAllRequestByUserId(userId);
		
		model.addAttribute("request", new Request());
		model.addAttribute("requestList", requestList);
		
		return "Request";
	}
	
	@PostMapping("/addRequest/{userId}")
	public String addRequest(@ModelAttribute("request") Request request, @PathVariable Integer userId, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "Request";
		}
		
		request.setUserId(userId);
		Integer id = requestRepository.createRequest(request);
		
		List<Request> requestList = requestRepository.getAllRequestByUserId(userId);
		model.addAttribute("requestList", requestList);
		
		if(id == -1) {
			model.addAttribute("errorMessage", "Create request failed.");
			return "Request";
		}
		
		return "Request";
	}
	
	@GetMapping("/removeRequest/{requestId}/{userId}")
	public String removeRequest(@PathVariable Integer requestId, @PathVariable Integer userId, Model model) {
		
		requestRepository.deleteRequest(requestId);
		
		model.addAttribute("userId", userId);
		return "forward:/request/"+userId;
	}
}

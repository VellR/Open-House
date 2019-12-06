package com.platform.open_house.controllers;

import java.sql.SQLException;
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
import com.platform.open_house.models.Trade;
import com.platform.open_house.repositories.ItemRepository;
import com.platform.open_house.repositories.RequestRepository;
import com.platform.open_house.repositories.TradeRepository;

@Controller
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private TradeRepository tradeRepository;
	
	@GetMapping("/request/{userId}")
	public String requestPage(@PathVariable Integer userId, Model model) {
		
		List<Request> requestList = requestRepository.getAllRequestByUserId(userId);
		
		model.addAttribute("request", new Request());
		model.addAttribute("requestList", requestList);
		
		return "Request";
	}
	
	@GetMapping("/userRequest/{userId}/{requestId}")
	public String userRequest(@PathVariable Integer userId, @PathVariable Integer requestId, Model model) throws SQLException {
		
		Request request = requestRepository.getRequestById(requestId);
		
		model.addAttribute("request", request);
		model.addAttribute("userId", userId);
		
		return "UserRequest";
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
	
	@GetMapping("/fulfillRequest/{userId}/{requestId}")
	public String fulfillRequest(@PathVariable Integer requestId, @PathVariable Integer userId, Model model) throws SQLException {
		
		Request request = requestRepository.getRequestById(requestId);
		Item item = new Item(userId, request.getName(), request.getDescription(), request.getPrice(), "0000-00-00");
		
		Integer buyerId = request.getUserId();
		Integer sellerId = userId; 
		Integer itemId = itemRepository.createItem(item);
		
		Trade trade = new Trade(itemId, sellerId, buyerId);
		
		tradeRepository.createTrade(trade);
		requestRepository.deleteRequest(requestId);
		
		return "forward:/userTrades/" + userId;
	}
	
	@GetMapping("/removeRequest/{requestId}/{userId}")
	public String removeRequest(@PathVariable Integer requestId, @PathVariable Integer userId, Model model) {
		
		requestRepository.deleteRequest(requestId);
		
		model.addAttribute("userId", userId);
		return "forward:/request/"+userId;
	}
}

package com.platform.open_house.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.platform.open_house.models.Item;
import com.platform.open_house.models.Trade;
import com.platform.open_house.repositories.ItemRepository;
import com.platform.open_house.repositories.TradeRepository;
import com.platform.open_house.repositories.UserRepository;

@Controller
public class TradeController {
	
	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/userTrades/{userId}")
	public String tradePage(@PathVariable Integer userId, Model model) throws SQLException {
		
		Map<String, List<Item>> buyerTradeList = new HashMap<>();
		List<Trade> tradeList = tradeRepository.getAllTradesBySellerId(userId);
		
		for(int i=0; i < tradeList.size(); i++) {
			
			int buyerId = tradeList.get(i).getBuyerId();
			String buyerName = userRepository.getUserById(buyerId).getUsername();
			
			List<Item> buyerItemList = new ArrayList<>();
			for(Trade trade : tradeList) {
				if(trade.getBuyerId() == buyerId)
					buyerItemList.add(itemRepository.getItemById(trade.getItemId()));
			}
			
			buyerTradeList.put(buyerName, buyerItemList);
		}
		
		Map<String, List<Item>> sellerTradeList = new HashMap<>();
		tradeList = tradeRepository.getAllTradesByBuyerId(userId);
		
		for(int i=0; i < tradeList.size(); i++) {
			
			int sellerId = tradeList.get(i).getBuyerId();
			String sellerName = userRepository.getUserById(sellerId).getUsername();
			
			List<Item> sellerItemList = new ArrayList<>();
			for(Trade trade : tradeList) {
				if(trade.getBuyerId() == sellerId)
					sellerItemList.add(itemRepository.getItemById(trade.getItemId()));
			}
			
			sellerTradeList.put(sellerName, sellerItemList);
		}
		
		model.addAttribute("buyerTradeList", buyerTradeList);
		model.addAttribute("sellerTradeList", sellerTradeList);
		model.addAttribute("trade", new Trade());
		return "Trade";
	}
	
	@GetMapping("startTrade/postUserTrade/{userId}")
	public String postTradePage(@PathVariable Integer userId, Model model) throws SQLException {
		
		Map<String, List<Item>> buyerTradeList = new HashMap<>();
		List<Trade> tradeList = tradeRepository.getAllTradesBySellerId(userId);
		
		for(int i=0; i < tradeList.size(); i++) {
			
			int buyerId = tradeList.get(i).getBuyerId();
			String buyerName = userRepository.getUserById(buyerId).getUsername();
			
			List<Item> buyerItemList = new ArrayList<>();
			for(Trade trade : tradeList) {
				if(trade.getBuyerId() == buyerId)
					buyerItemList.add(itemRepository.getItemById(trade.getItemId()));
			}
			
			buyerTradeList.put(buyerName, buyerItemList);
		}
		
		model.addAttribute("buyerTradeList", buyerTradeList);
		model.addAttribute("trade", new Trade());
		return "Trade";
	}
	
	
	@PostMapping("/startTrade/{userId}")
	public String startTrade(@PathVariable Integer userId, @ModelAttribute("item") Item item, Model model) {
		
		Integer buyerId = userId;
		Integer sellerId = item.getUserId();
		
		if(buyerId != sellerId) {
			Integer itemId = item.getId();
			
			Trade trade = new Trade(itemId, sellerId, buyerId);
			tradeRepository.createTrade(trade);
			
			return "redirect:postUserTrade/"+userId;
		}
		
		return "redirect:userTrades/"+userId;
	}
	
}

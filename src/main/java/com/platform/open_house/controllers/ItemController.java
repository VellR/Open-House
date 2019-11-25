package com.platform.open_house.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.platform.open_house.models.Item;
import com.platform.open_house.repositories.ItemRepository;

@Controller
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/userItems/{userId}")
	public String userItemPage(@PathVariable Integer userId, Model model) {
		
		model.addAttribute("item", new Item());
		return "UserItem";
	}
	
	@GetMapping("/browesableItems/{userId}")
	public String browseItems(@PathVariable Integer userId, Model model) throws ClassNotFoundException, IOException, SQLException {
		List<Item> itemList = itemRepository.getAllItems();
		
		for(Item item: itemList) {
			System.out.println(item.getName());
		}
		
		model.addAttribute("avaiableItems", itemList);
		model.addAttribute("item", new Item());
		
		return "SearchItems";
	}
	
	@GetMapping("/searchItems/{userId}")
	public String searchItems(@PathVariable Integer userId, Model model) {
		return "SearchItems";
	}
	
	@PostMapping("/addItem/{userId}")
	public String addItem(@Valid @ModelAttribute("item") Item item, @PathVariable Integer userId, Model model, BindingResult result) {
		
		if(result.hasErrors()) {
			return "UserItem";
		}
		
		item.setItemId(userId);
		Integer id = itemRepository.createItem(item);
		
		List<Item> itemList = itemRepository.getAllItemsByUserId(userId);
		model.addAttribute("itemList", itemList);
		
		if(id == -1) {
			model.addAttribute("errorMessage", "Create item failed.");
			return "UserItem";
		}
		
		return "UserItem";
	}
}

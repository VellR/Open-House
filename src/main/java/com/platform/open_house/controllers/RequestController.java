package com.platform.open_house.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.platform.open_house.repositories.RequestRepository;

@Controller
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;
	
	
}

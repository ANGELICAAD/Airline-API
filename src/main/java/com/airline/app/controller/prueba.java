package com.airline.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
public class prueba {

	@RequestMapping("/")
	public String hello() {   
		return "Hello, world"; 
	}
}

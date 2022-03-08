package com.airline.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.app.service.CityService;

@RestController
@RequestMapping("/api/city")
@CrossOrigin({"*"})
public class CityController {

	@Autowired
	public CityService cityService;
	
	@GetMapping("/{name}")
	public ResponseEntity<?> visaRequired(@PathVariable String name, ModelMap Model) {
		return ResponseEntity.ok(cityService.visaRequired(name));
	}
}

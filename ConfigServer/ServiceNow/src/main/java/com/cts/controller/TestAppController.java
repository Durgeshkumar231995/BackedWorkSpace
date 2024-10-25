package com.cts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAppController {
	
	@Value("${Name}")
	String Name;
	
	@GetMapping("/getName")
	public String getNamefromRepo() {
		return Name;
	}

}

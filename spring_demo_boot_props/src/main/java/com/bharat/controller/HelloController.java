package com.bharat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${dummy.name}")
	private String name;

	@GetMapping("/sayHello")
	public String sayHello() {
		return "HELLO!!";
	}

	@GetMapping("/getNameProp")
	public String getName() {
		return name;
	}
}

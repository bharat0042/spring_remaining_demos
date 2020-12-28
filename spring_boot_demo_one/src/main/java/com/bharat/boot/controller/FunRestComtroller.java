package com.bharat.boot.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestComtroller {

	@GetMapping("/")
	public String funController() {
		return "Hello World! TimeStamp : " + LocalDateTime.now();
	}
}

package com.bharat.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaderPage() {
		return "leaders";
	}
	
	@GetMapping("/admins")
	public String showAdminsPage() {
		return "admins";
	}
	
	@GetMapping("/accessDenied")
	public String accessDeniedPage() {
		return "accessDenied";
	}
}

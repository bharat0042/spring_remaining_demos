package com.bharat.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NormalController {

	@RequestMapping("/")
	public String sayHello() {
		return "/WEB-INF/index.jsp";
	}
}

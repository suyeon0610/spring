package com.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01") //∏µ≈©∑Œ ¿Ãµø
	public void resEx01() {}
	
	@GetMapping("/test")
	public void test(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		model.addAttribute("nick", "∏€∏€¿Ã");
	}
	

}

package com.springboot.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/") 
public class HelloWorldController {
	@RequestMapping("/")
	//@GetMapping("/")
	public String helloMain() {
		return "Hello Main!";
	}
}
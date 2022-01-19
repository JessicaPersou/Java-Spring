package com.example.Hello.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class Hello2Controller {
	
	@GetMapping
	public String hello() {
		return "Meu objetivo é aprender Spring-boot e entender todos os conceitos usados e para quê são usados!";
	}
	
}

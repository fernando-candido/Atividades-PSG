package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@GetMapping("/get")
	public String testar() {
		return "Hello World!";

	}
	
	@GetMapping("/get01")
	public String testar01() {
		return "Olá Mundo!";

	}
	

}

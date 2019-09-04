package br.com.livrariaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String index() {
		
		System.out.println("Entrando na Home da Livraria Spring");
		
		return "home";
		
	}
	

}

package br.com.livrariaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.livrariaspring.models.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/form")
	public String form() {

		System.out.println("Entrando no Produtos Controller");
		
		return "/produtos/form";
	}
	
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		
		System.out.println(produto);
		
		
		return "produtos/livrogravado";
		
	}

}

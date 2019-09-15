package br.com.livrariaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livrariaspring.dao.ProdutoDao;
import br.com.livrariaspring.models.Produto;
import br.com.livrariaspring.models.TipoPreco;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDao produtoDao;

	@RequestMapping("/produtos/form")
	public ModelAndView form() {

		System.out.println("Entrando no Produtos Controller");
		
		//Enviando o objeto preco para o form jsp Produto
		ModelAndView modelAndView = new ModelAndView("/produtos/form");
		modelAndView.addObject("tipos",TipoPreco.values());
		
		return modelAndView;
	}
	
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		
		System.out.println(produto);
		
		produtoDao.gravar(produto);
		return "produtos/livrogravado";
		
	}

}

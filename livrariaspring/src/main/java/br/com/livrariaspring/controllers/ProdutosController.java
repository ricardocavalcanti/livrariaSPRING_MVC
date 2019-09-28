package br.com.livrariaspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.livrariaspring.dao.ProdutoDao;
import br.com.livrariaspring.models.Produto;
import br.com.livrariaspring.models.TipoPreco;
import br.com.livrariaspring.validation.ProdutoValidation;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDao produtoDao;
	
	//AMARRA O PRODUTOVALIDATION
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.addValidators(new ProdutoValidation());
		
	}
	

	@RequestMapping("/form")
	public ModelAndView form() {

		System.out.println("Entrando no Produtos Controller");

		// Enviando o objeto preco para o form jsp Produto
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {

		System.out.println(produto);
		
		//VALIDACAO CAMPOS PRODUTO
		if(result.hasErrors()) {
			
			return form();
			
			
		}
		
		produtoDao.gravar(produto);		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

		return new ModelAndView("redirect:produtos");

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {

		System.out.println("Entrando no Produtos Controller - Listar");

		List<Produto> listaProdutos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("listaProdutos", listaProdutos);

		return modelAndView;
	}

}

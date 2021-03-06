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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.livrariaspring.dao.ProdutoDao;
import br.com.livrariaspring.infra.FileSaver;
import br.com.livrariaspring.models.Produto;
import br.com.livrariaspring.models.TipoPreco;
import br.com.livrariaspring.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private FileSaver fileSaver;

	// AMARRA O PRODUTOVALIDATION @Valid
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.addValidators(new ProdutoValidation());

	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {

		System.out.println("Entrando no ProdutosController - ModelAndView form()");

		// Enviando o objeto preco para o form jsp Produto
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {

		System.out.println("Entrando ProdutosController - ModelAndView gravar()");
		System.out.println(produto);
     	System.out.println("NOME ARQUIVO: "+sumario.getOriginalFilename());
		
		

		// VALIDACAO CAMPOS PRODUTO
		if (result.hasErrors()) {

			return form(produto);

		}

		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
		produtoDao.gravar(produto);
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

		return new ModelAndView("redirect:/produtos");

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {

		System.out.println("Entrando ProdutosController - ModelAndView listar()");

		List<Produto> listaProdutos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("listaProdutos", listaProdutos);

		return modelAndView;
	}

}

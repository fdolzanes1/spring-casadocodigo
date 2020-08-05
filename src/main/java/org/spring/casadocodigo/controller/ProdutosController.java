package org.spring.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.spring.casadocodigo.dao.ProdutoDAO;
import org.spring.casadocodigo.models.Produto;
import org.spring.casadocodigo.models.TipoPreco;
import org.spring.casadocodigo.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao; 
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
	    ModelAndView modelAndView = new ModelAndView("produtos/form");
	    modelAndView.addObject("tipos", TipoPreco.values());
	    return modelAndView;    
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
	        return form();
	    }
	    produtoDao.gravar(produto);
	    redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
	    return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produto = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produto);
		return modelAndView;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
	    binder.addValidators(new ProdutoValidation());
	}

}

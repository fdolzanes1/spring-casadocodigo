package org.spring.casadocodigo.controller;

import org.spring.casadocodigo.dao.ProdutoDAO;
import org.spring.casadocodigo.models.Produto;
import org.spring.casadocodigo.models.TipoPreco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/produtos")
	public String grava(Produto produto){
	    produtoDao.gravar(produto);
	    return "/produtos/ok";
	}

}

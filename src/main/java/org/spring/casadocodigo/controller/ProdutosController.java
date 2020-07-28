package org.spring.casadocodigo.controller;

import org.spring.casadocodigo.dao.ProdutoDAO;
import org.spring.casadocodigo.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao; 
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String grava(Produto produto){
	    produtoDao.gravar(produto);
	    return "/produtos/ok";
	}

}

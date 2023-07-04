package com.trabalho.poo.controllers;

import com.trabalho.poo.entities.Produto;
import com.trabalho.poo.services.GenericService;
import com.trabalho.poo.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produtos")
public class ProdutoController extends GenericController<Produto>{

	final ProdutoService produtoService;
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}


	@Override
	GenericService<Produto> getService() {
		return produtoService;
	}

}

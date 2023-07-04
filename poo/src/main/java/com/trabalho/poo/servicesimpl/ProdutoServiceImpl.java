package com.trabalho.poo.servicesimpl;

import com.trabalho.poo.entities.Produto;
import com.trabalho.poo.repositories.GenericRepository;
import com.trabalho.poo.repositories.ProdutoRepository;
import com.trabalho.poo.services.ProdutoService;
import org.springframework.stereotype.Service;


@Service
public class ProdutoServiceImpl implements ProdutoService {

	final ProdutoRepository produtoRepository;
	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public GenericRepository<Produto> getRepository() {
		return produtoRepository;
	}

	

}

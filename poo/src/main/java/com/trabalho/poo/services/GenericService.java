package com.trabalho.poo.services;

import com.trabalho.poo.entities.GenericEntity;
import com.trabalho.poo.repositories.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GenericService<TEntidade extends GenericEntity> {
	
	GenericRepository<TEntidade> getRepository();
	
	default void validateSave(TEntidade objeto) throws Exception {
		if (objeto.getNome() == null || objeto.getNome().isEmpty())
			throw new Exception("É necessário informar um nome válido");
		if (getRepository().existsByNomeAndIdNot(objeto.getNome(), objeto.getId()))
			throw new Exception("Já existe registro com este nome!");
	}
	
	default TEntidade save(TEntidade objeto) throws Exception{
		this.validateSave(objeto);
		return this.getRepository().save(objeto);
	}
	
	default TEntidade findById(Long id) throws Exception{
		var objeto = getRepository().findById(id);
		if (objeto.isEmpty())
			throw new Exception("Não existe cadastro com o Id: " + id);
		return objeto.get();
	}
	
	default Page<TEntidade> findByNome(String nome, Pageable pageable) throws Exception{
		return getRepository().findByNomeContainingIgnoreCase(nome, pageable);
	}
	
	default void deleteById(Long id) throws Exception{
		if (getRepository().existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		getRepository().deleteById(id);
	}

}

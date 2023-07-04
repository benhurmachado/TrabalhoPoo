package com.trabalho.poo.repositories;

import com.trabalho.poo.entities.GenericEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericRepository<TEntidade extends GenericEntity> extends JpaRepository<TEntidade, Long>{
	
	Page<TEntidade> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	
	boolean existsByNomeAndIdNot(String nome, long id);
	
	Page<TEntidade> findByNome(String nome, Pageable pageable);

}

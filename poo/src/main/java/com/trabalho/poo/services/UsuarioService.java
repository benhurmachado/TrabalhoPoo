package com.trabalho.poo.services;



import com.trabalho.poo.entities.Usuario;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsuarioService extends GenericService<Usuario>, UserDetailsService{

	void alteraStatus(@Param("id") long id) throws Exception;

}

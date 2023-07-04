package com.trabalho.poo.servicesimpl;

import com.trabalho.poo.entities.Usuario;
import com.trabalho.poo.repositories.UsuarioRepository;
import com.trabalho.poo.services.UsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	final UsuarioRepository usuarioRepository;
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public void validateSave(Usuario objeto) throws Exception {
		UsuarioService.super.validateSave(objeto);
		if (objeto.getEmail() == null || objeto.getEmail().isEmpty())
			throw new Exception("É necessário informar um e-mail válido");
		if (getRepository().existsByEmailAndIdNot(objeto.getEmail(), objeto.getId()))
			throw new Exception("Já existe usuário com este e-mail!");
	}

	@Override
	public UsuarioRepository getRepository() {
		return usuarioRepository;
	}
	@Override
	@Transactional
	public void alteraStatus(long id) throws Exception {
		if (!usuarioRepository.existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		usuarioRepository.alteraStatus(id);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Não foi possível localizar o usuário com este e-mail"));
		return usuario;
	}


}

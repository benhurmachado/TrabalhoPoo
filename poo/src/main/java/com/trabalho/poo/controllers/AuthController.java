package com.trabalho.poo.controllers;

import java.security.SecureRandom;

import com.trabalho.poo.components.JwtUtils;
import com.trabalho.poo.controllers.payloads.SigninPayload;
import com.trabalho.poo.controllers.payloads.SignupPayload;
import com.trabalho.poo.entities.Usuario;
import com.trabalho.poo.services.UsuarioService;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Signing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	private final UsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;
	private final JwtUtils jwtUtils;
	public AuthController(UsuarioService usuarioService, PasswordEncoder passwordEncoder
			, AuthenticationManager authManager, JwtUtils jwtUtils) {
		super();
		this.usuarioService = usuarioService;
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
		this.jwtUtils = jwtUtils;
	}
	@PostMapping("/signin")
	public ResponseEntity<Object> login(@RequestBody SigninPayload signin) {
		try {
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(signin.getEmail(), signin.getSenha()));
			String jwt = jwtUtils.generateTokenFromEmail(signin.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body(jwt);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PostMapping("/signup")
	public ResponseEntity<Object> autoCadastro(@RequestBody SignupPayload signup) {
		try {
			Usuario usuarioNovo = new Usuario();
			usuarioNovo.setNome(signup.getNome());
			usuarioNovo.setEmail(signup.getEmail());
			usuarioNovo.setStatus(true);
			String senha = gerarSenhaAleatoria(10);
			usuarioNovo.setSenha(passwordEncoder.encode(senha));
			usuarioService.save(usuarioNovo);
			return ResponseEntity.status(HttpStatus.OK).body(senha);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	private String gerarSenhaAleatoria(int tamanho) {
		String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(caracteresPermitidos.length());
            senha.append(caracteresPermitidos.charAt(indice));
        }
        return senha.toString();
    }

}

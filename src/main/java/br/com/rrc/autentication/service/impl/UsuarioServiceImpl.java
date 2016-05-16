package br.com.rrc.autentication.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.rrc.autentication.beans.Usuario;
import br.com.rrc.autentication.repository.UsuarioRepository;
import br.com.rrc.autentication.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}

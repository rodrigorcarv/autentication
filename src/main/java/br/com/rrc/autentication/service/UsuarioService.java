package br.com.rrc.autentication.service;

import org.springframework.stereotype.Service;

import br.com.rrc.autentication.beans.Usuario;
import br.com.rrc.autentication.repository.UsuarioRepository;
import br.com.rrc.autentication.service.impl.UsuarioServiceImpl;

@Service
public class UsuarioService implements UsuarioServiceImpl {

	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}

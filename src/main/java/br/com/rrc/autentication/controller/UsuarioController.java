package br.com.rrc.autentication.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rrc.autentication.beans.Usuario;
import br.com.rrc.autentication.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Inject
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody Usuario save (@RequestBody  Usuario usuario){
		return usuarioService.save(usuario);
	}
}

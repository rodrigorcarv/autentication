package br.com.rrc.autentication.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.rrc.autentication.AutenticationApplication;
import br.com.rrc.autentication.beans.Usuario;
import br.com.rrc.autentication.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AutenticationApplication.class)
@WebAppConfiguration
public class UsuarioServiceTest {

	@Spy
	private UsuarioService usuarioService; 
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void salvaUsuario() {
		
		String nome =  "Jose";
		String senha = "admin123";
		String email = "jose@gmail.com";
		Usuario usuario = new Usuario(nome, senha, email);
		
		Mockito.doReturn(usuario).when(usuarioService).save(usuario);
		
		usuarioService.save(usuario);
	}
}

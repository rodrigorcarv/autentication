package br.com.rrc.autentication.repository;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rrc.autentication.AutenticationApplication;
import br.com.rrc.autentication.beans.Telefone;
import br.com.rrc.autentication.beans.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AutenticationApplication.class)
@Transactional
public class UsuarioRepositoryTest {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
 
    @Test
    public void testSaveUsuario(){
    	
		String email = "jose@gmail.com";
		String senha = "admin123";
		String nome = "Jose";
		
		//Usuario usuario = new Usuario(nome, senha, email, tefones);
		Usuario usuario = new Usuario(nome, senha, email);
    	
        Assert.assertNull(usuario.getId()); //null before save
        usuarioRepository.save(usuario);
        Assert.assertNotNull(usuario.getId()); //not null after save
 
        //fetch from DB
        Usuario fetchedProduct = usuarioRepository.findOne(usuario.getId());
 
        //should not be null
        Assert.assertNotNull(fetchedProduct);
    }
	
    @Test
    public void testSaveUsuarioComTelefone(){
    	
		String email = "jose@gmail.com";
		String senha = "admin123";
		String nome = "Jose";

		Set<Telefone> tefones = new HashSet<>();
		
		String ddd = "13";
		String numero = "981114355";
		Telefone telefone = new Telefone(ddd, numero);
		
		tefones.add(telefone);
		Usuario usuario = new Usuario(nome, senha, email, tefones );
		
    	
        Assert.assertNull(usuario.getId()); //null before save
        usuarioRepository.save(usuario);
        Assert.assertNotNull(usuario.getId()); //not null after save
 
        //fetch from DB
        Usuario fetchedProduct = usuarioRepository.findOne(usuario.getId());
 
        //should not be null
        Assert.assertNotNull(fetchedProduct);
    }
}

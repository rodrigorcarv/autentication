package br.com.rrc.autentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rrc.autentication.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
	List<Usuario> findByNome(String nome);
}

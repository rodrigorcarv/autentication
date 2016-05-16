package br.com.rrc.autentication.beans;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {

	public Usuario(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome, String senha, String email, Set<Telefone> telefones) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}

	@Id
	@SequenceGenerator(name="USUARIO_GENERATOR",sequenceName="SEQ_USUARIO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USUARIO_GENERATOR")
	private Long id;
	
	private String nome;
	private String email;
	private String senha;

	@OneToMany(mappedBy = "usuario",targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Telefone> telefones;

	public String getSenha() {
		return senha;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}
}

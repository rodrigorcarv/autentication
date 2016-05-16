package br.com.rrc.autentication.beans;


import java.util.Set;

import javax.persistence.Entity;

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

	private Long id;
	private String nome;
	private String email;
	private String senha;
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

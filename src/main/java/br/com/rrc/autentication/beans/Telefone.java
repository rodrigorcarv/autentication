package br.com.rrc.autentication.beans;

import javax.persistence.Entity;

@Entity
public class Telefone {

	private Long id;
	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}
	public String getNumero() {
		return numero;
	}

	public Long getId() {
		return id;
	}
}

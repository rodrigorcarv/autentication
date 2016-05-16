package br.com.rrc.autentication.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Telefone {

	@Id
	@SequenceGenerator(name="TELEFONE_GENERATOR",sequenceName="SEQ_TELEFONE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TELEFONE_GENERATOR")
	private Long id;
	private String ddd;
	private String numero;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Telefone () {}
	
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
	public Usuario getUsuario() {
		return usuario;
	}
}

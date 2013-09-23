package com.jnaldo.podoteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "participante")
public class Participante extends EntidadeBase {

	@NotEmpty
	@Length(min = 3, max = 255)
	@Column(name = "nome")
	private String nome;

	@Email
	@Length(max = 255)
	@Column(name = "email")
	private String email;

	@Length(max = 255)
	@Column(name = "apelido")
	private String apelido;

	@Length(max = 255)
	@Column(name = "twitter")
	private String twitter;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}

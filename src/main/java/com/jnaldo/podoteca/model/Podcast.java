package com.jnaldo.podoteca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "podcast")
public class Podcast extends EntidadeBase {

	@NotEmpty
	@Length(min = 3, max = 200)
	@Column(name = "nome")
	private String nome;

	@NotEmpty
	@URL
	@Column(name = "site")
	private String site;

	@NotEmpty
	@Length(min = 20, max = 200)
	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "podcast")
	private List<Episodio> episodios;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Episodio> getEpisodios() {
		return this.episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}

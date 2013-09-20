package com.jnaldo.podoteca.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class Podcast extends EntidadeBase {

	@NotEmpty
	@Length(min = 3, max = 200)
	private String nome;

	@NotEmpty
	@URL
	private String site;

	@NotEmpty
	@Length(min = 20, max = 200)
	private String descricao;

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

}

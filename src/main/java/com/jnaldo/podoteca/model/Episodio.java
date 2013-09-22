package com.jnaldo.podoteca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "episodio")
public class Episodio extends EntidadeBase {

	@NotEmpty
	@Length(min = 3, max = 255)
	@Column(name = "titulo")
	private String titulo;

	@NotEmpty
	@Length(min = 20, max = 2000)
	@Column(name = "descricao")
	private String descricao;

	@NotEmpty
	@URL
	@Length(max = 255)
	@Column(name = "url")
	private String url;

	@ManyToOne
	@JoinColumn(name = "podcast_id")
	private Podcast podcast;

	@ManyToMany
	@JoinTable(name = "participantes_episodios", joinColumns = { @JoinColumn(name = "episodio_id") }, inverseJoinColumns = { @JoinColumn(name = "participante_id") })
	private List<Participante> participantes;

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Podcast getPodcast() {
		return this.podcast;
	}

	public void setPodcast(Podcast podcast) {
		this.podcast = podcast;
	}
}

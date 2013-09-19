package com.jnaldo.podoteca.domain;

import java.util.List;

public class Episodio {

	private String titulo;
	private String descricao;
	private String urlDoArquivo;

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

	public String getUrlDoArquivo() {
		return this.urlDoArquivo;
	}

	public void setUrlDoArquivo(String urlDoArquivo) {
		this.urlDoArquivo = urlDoArquivo;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
}

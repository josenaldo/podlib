package com.jnaldo.podoteca.web;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.jnaldo.podoteca.model.Participante;

public class EpisodioParticipantesForm {

	private Long id;

	private String titulo;

	@NotEmpty
	private List<Participante> participantes;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

}

package com.jnaldo.podoteca.web;

import java.util.List;

import com.jnaldo.podoteca.model.Episodio;
import com.jnaldo.podoteca.model.Participante;

public class EpisodioParticipantesForm {
	private Episodio episodio;

	private List<Participante> participantes;

	public Episodio getEpisodio() {
		return this.episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

}

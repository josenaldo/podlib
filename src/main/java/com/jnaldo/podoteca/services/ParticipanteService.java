package com.jnaldo.podoteca.services;

import java.util.List;

import com.jnaldo.podoteca.model.Participante;

public interface ParticipanteService {

	List<Participante> findAll();

	void save(Participante participante);

	Participante find(Long id);

	void delete(Long id);

}

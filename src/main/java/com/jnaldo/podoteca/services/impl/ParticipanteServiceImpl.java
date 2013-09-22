package com.jnaldo.podoteca.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.repository.ParticipanteRepository;
import com.jnaldo.podoteca.services.ParticipanteService;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public void save(Participante participante) {
		this.participanteRepository.save(participante);
	}

	public List<Participante> findAll() {
		Iterable<Participante> participantes = this.participanteRepository
				.findAll();
		List<Participante> participanteList = new ArrayList<Participante>();

		if (participantes != null && participantes.iterator().hasNext()) {
			for (Participante participante : participantes) {
				participanteList.add(participante);
			}
		}

		return participanteList;
	}

	public Participante find(Long id) {
		Participante participante = this.participanteRepository.findOne(id);

		return participante;
	}

	public void delete(Long id) {
		this.participanteRepository.delete(id);
	}

}

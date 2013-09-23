package com.jnaldo.podoteca.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.repository.ParticipanteRepository;
import com.jnaldo.podoteca.business.services.ParticipanteService;
import com.jnaldo.podoteca.model.Participante;
import com.jnaldo.podoteca.util.message.Messages;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public void save(Participante participante) throws BusinessException {

		try {
			this.participanteRepository.save(participante);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.PARTICIPANTE_NAO_SALVO);
		}

	}

	public void delete(Long id) throws BusinessException {

		try {
			this.participanteRepository.delete(id);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.PARTICIPANTE_NAO_APAGADO);
		}
	}

	public Participante find(Long id) throws BusinessException {

		Participante participante = this.participanteRepository.findOne(id);

		if (participante == null) {
			throw new BusinessException(Messages.PARTICIPANTE_NAO_ENCONTRADO);
		}

		return participante;
	}

	public List<Participante> findAll() throws BusinessException {
		Iterable<Participante> participantes = this.participanteRepository
				.findAll();
		List<Participante> participanteList = new ArrayList<Participante>();

		if (participantes == null || !participantes.iterator().hasNext()) {
			throw new BusinessException(Messages.PARTICIPANTE_LISTA_VAZIA);
		}

		for (Participante participante : participantes) {
			participanteList.add(participante);
		}

		return participanteList;
	}
}

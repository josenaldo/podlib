package com.jnaldo.podoteca.business.services;

import java.util.List;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.model.Participante;

public interface ParticipanteService {

	void save(Participante participante) throws BusinessException;

	void delete(Long id) throws BusinessException;

	Participante find(Long id) throws BusinessException;

	List<Participante> findAll() throws BusinessException;

}

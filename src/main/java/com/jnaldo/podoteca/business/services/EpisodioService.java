package com.jnaldo.podoteca.business.services;

import java.util.List;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.model.Episodio;

public interface EpisodioService {

	void save(Episodio episodio) throws BusinessException;

	void delete(Long id) throws BusinessException;

	Episodio find(Long id) throws BusinessException;

	Episodio findEpisodioWithParticipantes(Long id) throws BusinessException;

	List<Episodio> findAll() throws BusinessException;

	List<Episodio> findAllEpisodiosWithParticipantes() throws BusinessException;

}

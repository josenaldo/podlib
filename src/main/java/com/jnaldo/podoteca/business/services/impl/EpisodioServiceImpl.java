package com.jnaldo.podoteca.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.repository.EpisodioRepository;
import com.jnaldo.podoteca.business.services.EpisodioService;
import com.jnaldo.podoteca.model.Episodio;
import com.jnaldo.podoteca.util.message.Messages;

@Service
public class EpisodioServiceImpl implements EpisodioService {

	@Autowired
	private EpisodioRepository episodioRepository;

	public void save(Episodio episodio) throws BusinessException {

		try {
			this.episodioRepository.save(episodio);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.EPISODIO_NAO_SALVO);
		}
	}

	public void delete(Long id) throws BusinessException {

		try {
			this.episodioRepository.delete(id);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.EPISODIO_NAO_APAGADO);
		}
	}

	public Episodio find(Long id) throws BusinessException {

		Episodio episodio = this.episodioRepository.findOne(id);

		if (episodio == null) {
			throw new BusinessException(Messages.EPISODIO_NAO_ENCONTRADO);
		}

		return episodio;
	}

	public Episodio findEpisodioWithParticipantes(Long id)
			throws BusinessException {
		Episodio episodio = this.episodioRepository
				.findEpisodioWithParticipantes(id);

		if (episodio == null) {
			throw new BusinessException(Messages.EPISODIO_NAO_ENCONTRADO);
		}

		return episodio;
	}

	public List<Episodio> findAll() throws BusinessException {

		Iterable<Episodio> episodios = this.episodioRepository.findAll();
		List<Episodio> episodioList = new ArrayList<Episodio>();

		if (episodios == null || !episodios.iterator().hasNext()) {
			throw new BusinessException(Messages.EPISODIO_LISTA_VAZIA);
		}

		for (Episodio episodio : episodios) {
			episodioList.add(episodio);
		}

		return episodioList;
	}

	public List<Episodio> findAllEpisodiosWithParticipantes()
			throws BusinessException {
		List<Episodio> episodios = this.episodioRepository
				.findAllEpisodiosWithParticipantes();

		if (episodios == null || episodios.isEmpty()) {
			throw new BusinessException(Messages.PODCAST_LISTA_VAZIA);
		}

		return episodios;
	}

}

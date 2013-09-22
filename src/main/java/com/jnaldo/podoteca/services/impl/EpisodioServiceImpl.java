package com.jnaldo.podoteca.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.model.Episodio;
import com.jnaldo.podoteca.repository.EpisodioRepository;
import com.jnaldo.podoteca.services.EpisodioService;

@Service
public class EpisodioServiceImpl implements EpisodioService {

	@Autowired
	private EpisodioRepository episodioRepository;

	public void save(Episodio episodio) {
		this.episodioRepository.save(episodio);
	}

	public List<Episodio> findAll() {
		Iterable<Episodio> episodios = this.episodioRepository.findAll();
		List<Episodio> episodioList = new ArrayList<Episodio>();

		if (episodios != null && episodios.iterator().hasNext()) {
			for (Episodio episodio : episodios) {
				episodioList.add(episodio);
			}
		}

		return episodioList;
	}

	public Episodio find(Long id) {
		Episodio episodio = this.episodioRepository.findOne(id);

		return episodio;
	}

	public void delete(Long id) {
		this.episodioRepository.delete(id);
	}

}

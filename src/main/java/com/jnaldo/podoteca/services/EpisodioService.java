package com.jnaldo.podoteca.services;

import java.util.List;

import com.jnaldo.podoteca.model.Episodio;

public interface EpisodioService {

	List<Episodio> findAll();

	void save(Episodio episodio);

	Episodio find(Long id);

	void delete(Long id);

}

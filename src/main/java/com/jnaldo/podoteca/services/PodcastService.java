package com.jnaldo.podoteca.services;

import java.util.List;

import com.jnaldo.podoteca.model.Podcast;

public interface PodcastService {

	List<Podcast> findAll();

	void save(Podcast podcast);

	Podcast find(Long id);

	void delete(Long id);

}

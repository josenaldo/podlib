package com.jnaldo.podoteca.business.services;

import java.util.List;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.model.Podcast;

public interface PodcastService {

	void save(Podcast podcast) throws BusinessException;

	void delete(Long id) throws BusinessException;

	Podcast find(Long id) throws BusinessException;

	Podcast findPodcastWithEpisodios(Long id) throws BusinessException;

	List<Podcast> findAll() throws BusinessException;

	List<Podcast> findAllPodcastsWithEpisodios() throws BusinessException;

}

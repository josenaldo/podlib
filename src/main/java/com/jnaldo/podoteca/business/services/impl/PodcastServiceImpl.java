package com.jnaldo.podoteca.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.business.exceptions.BusinessException;
import com.jnaldo.podoteca.business.repository.PodcastRepository;
import com.jnaldo.podoteca.business.services.PodcastService;
import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.util.message.Messages;

@Service
public class PodcastServiceImpl implements PodcastService {

	@Autowired
	private PodcastRepository podcastRepository;

	public void save(Podcast podcast) throws BusinessException {
		try {
			this.podcastRepository.save(podcast);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.PODCAST_NAO_SALVO);
		}
	}

	public void delete(Long id) throws BusinessException {
		try {
			this.podcastRepository.delete(id);
		} catch (DataAccessException e) {
			throw new BusinessException(Messages.PODCAST_NAO_APAGADO);
		}
	}

	public Podcast find(Long id) throws BusinessException {
		Podcast podcast = this.podcastRepository.findOne(id);

		if (podcast == null) {
			throw new BusinessException(Messages.PODCAST_NAO_ENCONTRADO);
		}

		return podcast;
	}

	public Podcast findPodcastWithEpisodios(Long id) throws BusinessException {
		Podcast podcast = this.podcastRepository.findPodcastWithEpisodios(id);

		if (podcast == null) {
			throw new BusinessException(Messages.PODCAST_NAO_ENCONTRADO);
		}

		return podcast;
	}

	public List<Podcast> findAll() throws BusinessException {
		Iterable<Podcast> podcasts = this.podcastRepository.findAll();
		List<Podcast> podcastList = new ArrayList<Podcast>();

		if (podcasts == null || !podcasts.iterator().hasNext()) {
			throw new BusinessException(Messages.PODCAST_LISTA_VAZIA);
		}

		for (Podcast podcast : podcasts) {
			podcastList.add(podcast);
		}

		return podcastList;
	}

	public List<Podcast> findAllPodcastsWithEpisodios()
			throws BusinessException {
		List<Podcast> podcasts = this.podcastRepository
				.findAllPodcastsWithEpisodios();

		if (podcasts == null || podcasts.isEmpty()) {
			throw new BusinessException(Messages.PODCAST_LISTA_VAZIA);
		}

		return podcasts;
	}

}

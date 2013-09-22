package com.jnaldo.podoteca.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jnaldo.podoteca.model.Podcast;
import com.jnaldo.podoteca.repository.PodcastRepository;
import com.jnaldo.podoteca.services.PodcastService;

@Service
public class PodcastServiceImpl implements PodcastService {

	@Autowired
	private PodcastRepository podcastRepository;

	public void save(Podcast podcast) {
		this.podcastRepository.save(podcast);
	}

	public List<Podcast> findAll() {
		Iterable<Podcast> podcasts = this.podcastRepository.findAll();
		List<Podcast> podcastList = new ArrayList<Podcast>();

		if (podcasts != null && podcasts.iterator().hasNext()) {
			for (Podcast podcast : podcasts) {
				podcastList.add(podcast);
			}
		}

		return podcastList;
	}

	public Podcast find(Long id) {
		Podcast podcast = this.podcastRepository.findOne(id);

		return podcast;
	}

	public void delete(Long id) {
		this.podcastRepository.delete(id);
	}

}

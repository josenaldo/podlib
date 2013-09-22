package com.jnaldo.podoteca.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jnaldo.podoteca.model.Podcast;

@Repository
public interface PodcastRepository extends
		PagingAndSortingRepository<Podcast, Long> {

}

package com.jnaldo.podoteca.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jnaldo.podoteca.model.Podcast;

@Repository
public interface PodcastRepository extends
		PagingAndSortingRepository<Podcast, Long> {

	@Query("select p from Podcast p LEFT JOIN FETCH p.episodios where p.id=?1")
	Podcast findPodcastWithEpisodios(Long id);

	@Query("select p from Podcast p LEFT JOIN FETCH p.episodios")
	List<Podcast> findAllPodcastsWithEpisodios();

}

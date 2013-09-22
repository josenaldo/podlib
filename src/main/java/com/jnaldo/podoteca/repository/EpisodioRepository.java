package com.jnaldo.podoteca.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jnaldo.podoteca.model.Episodio;

@Repository
public interface EpisodioRepository extends
		PagingAndSortingRepository<Episodio, Long> {

}

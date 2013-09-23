package com.jnaldo.podoteca.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jnaldo.podoteca.model.Episodio;

@Repository
public interface EpisodioRepository extends
		PagingAndSortingRepository<Episodio, Long> {

	@Query("select e from Episodio e LEFT JOIN FETCH e.participantes where e.id=?1")
	public Episodio findById(Long id);

}

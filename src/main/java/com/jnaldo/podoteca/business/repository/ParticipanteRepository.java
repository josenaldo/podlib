package com.jnaldo.podoteca.business.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jnaldo.podoteca.model.Participante;

@Repository
public interface ParticipanteRepository extends
		PagingAndSortingRepository<Participante, Long> {

}

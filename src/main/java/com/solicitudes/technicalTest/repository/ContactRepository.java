package com.solicitudes.technicalTest.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.solicitudes.technicalTest.entity.ContactEntity;

import reactor.core.publisher.Flux;

@Repository
public interface ContactRepository extends ReactiveCrudRepository<ContactEntity, Long>  {

	@Query("SELECT * FROM contacts WHERE id_solicitude = :idSolicitude")
	Flux<ContactEntity> findBySolicitudeId(Long idSolicitude);
}

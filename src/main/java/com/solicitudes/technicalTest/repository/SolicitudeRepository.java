package com.solicitudes.technicalTest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.solicitudes.technicalTest.entity.SolicitudeEntity;

@Repository
public interface SolicitudeRepository extends ReactiveCrudRepository<SolicitudeEntity, Long>  {

}

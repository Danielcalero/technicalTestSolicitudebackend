package com.solicitudes.technicalTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solicitudes.technicalTest.bean.SolicitudeBean;
import com.solicitudes.technicalTest.service.SolicitudeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/solicitude")
public class SolicitudeController {
	@Autowired
	private SolicitudeService solicitudeService;
	
    @GetMapping("/showAll")
    public Flux<SolicitudeBean> getAllSolicitudes() {
        return solicitudeService.getAllSolicitudes();
    }
    
    @GetMapping("/showById/{id}")
    public Mono<SolicitudeBean> getSolicitudById(@PathVariable("id") Long id) {
        return solicitudeService.getSolicitudById(id);
    }
    
    @PostMapping("/saveSolicitud")
    public Mono<SolicitudeBean> saveSolicitude(
            @RequestBody SolicitudeBean solicitude,
            @RequestHeader HttpHeaders headers) {
        return solicitudeService.saveSolicitude(solicitude);
    }
}

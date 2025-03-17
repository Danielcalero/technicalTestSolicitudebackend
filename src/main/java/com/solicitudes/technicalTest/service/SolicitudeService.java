package com.solicitudes.technicalTest.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solicitudes.technicalTest.bean.ContactBean;
import com.solicitudes.technicalTest.bean.SolicitudeBean;
import com.solicitudes.technicalTest.entity.ContactEntity;
import com.solicitudes.technicalTest.entity.SolicitudeEntity;
import com.solicitudes.technicalTest.repository.ContactRepository;
import com.solicitudes.technicalTest.repository.SolicitudeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SolicitudeService {
	  @Autowired
	  private SolicitudeRepository solicitudeRepository;
	  
	  @Autowired
	  private ContactRepository contactRepository;
	  
	  public Flux<SolicitudeBean> getAllSolicitudes() {
		  return solicitudeRepository.findAll()
			        .map(sol -> {
			            SolicitudeBean bean = new SolicitudeBean();
			            BeanUtils.copyProperties(sol, bean);
			            return bean;     
			        });

	    }
	  
	  public Mono<SolicitudeBean> getSolicitudById(Long id) {
		    return solicitudeRepository.findById(id)
		        .flatMap(solicitude -> contactRepository.findBySolicitudeId(id)
		            .collectList()
		            .map(contactEntities -> {
		                SolicitudeBean bean = new SolicitudeBean();
		                BeanUtils.copyProperties(solicitude, bean);

		                List<ContactBean> contactBeans = contactEntities.stream()
		                    .map(contactEntity -> {
		                        ContactBean contactBean = new ContactBean();
		                        BeanUtils.copyProperties(contactEntity, contactBean);
		                        return contactBean;
		                    })
		                    .collect(Collectors.toList());

		                bean.setContacts(contactBeans);
		                return bean;
		            })
		        );
		}


	  
	  public Mono<SolicitudeBean> saveSolicitude(SolicitudeBean solicitudBean) {
		    UUID uuid = UUID.randomUUID();
		    SolicitudeEntity entity = new SolicitudeEntity();

		    entity.setBrand(solicitudBean.getBrand());
		    entity.setType(solicitudBean.getType());
		    entity.setSendDate(solicitudBean.getSendDate());
		    entity.setContactNumber(solicitudBean.getContactNumber());
		    entity.setContactName(solicitudBean.getContactName());

		    if (solicitudBean.getId() == null) {
		        entity.setCode(uuid.toString());
		    } else {
		        entity.setCode(solicitudBean.getCode());
		        entity.setId(solicitudBean.getId());
		    }

		    return solicitudeRepository.save(entity)
		            .flatMap(savedEntity -> {
		                System.out.println("Guardado en BD: " + savedEntity);

		                List<ContactEntity> contacts = solicitudBean.getContacts().stream()
		                        .map(contactBean -> {
		                            ContactEntity contactEntity = new ContactEntity();
		                            BeanUtils.copyProperties(contactBean, contactEntity);
		                            contactEntity.setSolicitudeId(savedEntity.getId());
		                            return contactEntity;
		                        })
		                        .toList();

		                return contactRepository.saveAll(contacts) 
		                        .then(Mono.just(solicitudBean)); 
		            });
		}

}

package com.solicitudes.technicalTest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("contacts")
public class ContactEntity {
	
	@Id
    private Long id; 
    
    @Column("contact_number")
    private Long contactNumber;
    
    @Column("contact_name")
    private String contactName;
    
    @Column("id_solicitude") 
    private Long solicitudeId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getSolicitudeId() {
		return solicitudeId;
	}

	public void setSolicitudeId(Long solicitudeId) {
		this.solicitudeId = solicitudeId;
	}
}

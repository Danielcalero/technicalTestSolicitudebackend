package com.solicitudes.technicalTest.bean;

public class ContactBean {
   private Long id; 
   private Long contactNumber;
   private String contactName;
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

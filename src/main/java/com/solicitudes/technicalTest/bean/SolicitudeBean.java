package com.solicitudes.technicalTest.bean;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SolicitudeBean {
    private Long id; 
    private String brand;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendDate;
    private Long contactNumber;
	private String contactName;
	private String code;
    private List<ContactBean> contacts;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getSendDate() {
		return sendDate;
	}
	public void setSendDate(LocalDateTime sendDate) {
		this.sendDate = sendDate;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<ContactBean> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactBean> contacts) {
		this.contacts = contacts;
	}

}

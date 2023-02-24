package com.example.vitospizzaserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "unregistered_user", schema = "vitospizza")
public class UnregisteredUser {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "unregistered_user_seq_id")
	@SequenceGenerator(name = "unregistered_user_seq_id", schema = "vitospizza", sequenceName = "unregistered_user_seq")
	private Long id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
    private String lastname;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "phone")
    private String phone;
    
    
    
	public Long getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

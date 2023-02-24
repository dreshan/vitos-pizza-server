package com.example.vitospizzaserver.dto;

public class UnregisteredCart {

	private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private String pizzaName;
    private Double quantity;
    private Double amount;
    
    
    
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
	public String getPizzaName() {
		return pizzaName;
	}
	public Double getQuantity() {
		return quantity;
	}
	public Double getAmount() {
		return amount;
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
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}

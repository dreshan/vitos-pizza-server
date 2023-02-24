package com.example.vitospizzaserver.dto;

public class RegistedCart {

	private String username;
	private String pizzaName;
	private Long  quantity;
	private Double amount;
	
	
	public String getUsername() {
		return username;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}

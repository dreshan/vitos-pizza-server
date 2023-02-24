package com.example.vitospizzaserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart", schema = "vitospizza")
public class Cart {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cart_seq_id")
	@SequenceGenerator(name = "cart_seq_id", schema = "vitospizza", sequenceName = "cart_seq")
	private Long cartId;
	
	@Column(name = "pizza_name")
	private String pizzaName;
	
	@Column(name = "quantity")
    private Double quantity;
	
	@Column(name = "amount")
    private Double amount;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "cart_type")
	private String cartType;
    
    
	public Long getCartId() {
		return cartId;
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
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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
	public Long getUserId() {
		return userId;
	}
	public String getCartType() {
		return cartType;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setCartType(String cartType) {
		this.cartType = cartType;
	}
}
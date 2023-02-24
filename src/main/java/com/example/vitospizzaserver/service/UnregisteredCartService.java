package com.example.vitospizzaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vitospizzaserver.dao.CartDao;
import com.example.vitospizzaserver.dao.UnregisteredUserDao;
import com.example.vitospizzaserver.model.Cart;
import com.example.vitospizzaserver.model.UnregisteredCart;
import com.example.vitospizzaserver.model.UnregisteredUser;

@Service
public class UnregisteredCartService {
	

	
	@Autowired
	private UnregisteredUserDao unregisteredUserDao;
	
	@Autowired
	private CartDao cartDao;
	 
	

	public void processUnregistedCart(UnregisteredCart unregisteredCart) {
		persistUnregistedCart(unregisteredCart);
		
		ersistCart(unregisteredCart);
	}

	private void ersistCart(UnregisteredCart unregisteredCart) {
		Cart cart = buidCart(unregisteredCart);
		cartDao.save(cart);
	}

	private void persistUnregistedCart(UnregisteredCart unregisteredCart) {
		UnregisteredUser unregisteredUser = buildUnregistedUser(unregisteredCart);
		unregisteredUserDao.save(unregisteredUser);
	}
	
	private UnregisteredUser buildUnregistedUser(UnregisteredCart unregisteredCart) {
		
		System.out.println("buildUnregistedUser :::::::::::::");
		UnregisteredUser unregisteredUser = new UnregisteredUser();
		unregisteredUser.setAddress(unregisteredCart.getAddress());
		unregisteredUser.setEmail(unregisteredCart.getEmail());
		unregisteredUser.setFirstname(unregisteredCart.getFirstname());
		unregisteredUser.setLastname(unregisteredCart.getLastname());
		unregisteredUser.setPhone(unregisteredCart.getPhone());
		
		return unregisteredUser;
	}
	
	private Cart buidCart(UnregisteredCart unregisteredCart) {
		Cart cart = new Cart();
		cart.setAmount(unregisteredCart.getAmount());
		cart.setPizzaName(unregisteredCart.getPizzaName());
		cart.setQuantity(unregisteredCart.getQuantity());
		
		return cart;
	}
}

package com.example.vitospizzaserver.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vitospizzaserver.dao.CartDao;
import com.example.vitospizzaserver.dao.UnregisteredUserDao;
import com.example.vitospizzaserver.dto.UnregisteredCart;
import com.example.vitospizzaserver.model.Cart;
import com.example.vitospizzaserver.model.UnregisteredUser;

@Service
public class UnregisteredCartService {
	
	private static final String UNEGISTERED_USER = "UU";
	
	@Autowired
	private UnregisteredUserDao unregisteredUserDao;
	
	@Autowired
	private CartDao cartDao;
	 
	

	public void processUnregistedCart(UnregisteredCart unregisteredCart) {
		saveOrUpdateUnregistedCart(unregisteredCart);
		
		saveOrUpdateCart(unregisteredCart);
	}

	private void saveOrUpdateCart(UnregisteredCart unregisteredCart) {
		Cart cart = buidCart(unregisteredCart);
		cartDao.save(cart);
	}

	private void saveOrUpdateUnregistedCart(UnregisteredCart unregisteredCart) {
		 buildUnregistedUser(unregisteredCart);
		
	}
	
	private void buildUnregistedUser(UnregisteredCart unregisteredCart) {
		
		UnregisteredUser unregisteredUser = unregisteredUserDao.findUnregisteredUserByPhone(unregisteredCart.getPhone());
		if (null == unregisteredUser) {
			System.out.println("buildUnregistedUser :::::::::::::");
			unregisteredUser = new UnregisteredUser();
			unregisteredUser.setAddress(unregisteredCart.getAddress());
			unregisteredUser.setEmail(unregisteredCart.getEmail());
			unregisteredUser.setFirstName(unregisteredCart.getFirstname());
			unregisteredUser.setLastName(unregisteredCart.getLastname());
			unregisteredUser.setPhone(unregisteredCart.getPhone());
			unregisteredUserDao.save(unregisteredUser);
		}
		
	}
	
	private Cart buidCart(UnregisteredCart unregisteredCart) {
		UnregisteredUser unregisteredUser = unregisteredUserDao.findUnregisteredUserByPhone(unregisteredCart.getPhone());
		Cart cart = new Cart();
		cart.setAmount(unregisteredCart.getAmount());
		cart.setPizzaName(unregisteredCart.getPizzaName());
		cart.setQuantity(unregisteredCart.getQuantity());
		cart.setUserId(unregisteredUser.getId().toString());
		cart.setCartType(UNEGISTERED_USER);
		cart.setOrderDate(Calendar.getInstance().getTime());
		
		return cart;
	}
}

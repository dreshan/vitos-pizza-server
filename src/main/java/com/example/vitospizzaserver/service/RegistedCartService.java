package com.example.vitospizzaserver.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vitospizzaserver.dao.CartDao;
import com.example.vitospizzaserver.dao.UserDao;
import com.example.vitospizzaserver.dto.RegistedCart;
import com.example.vitospizzaserver.model.Cart;
import com.example.vitospizzaserver.model.User;

@Service
public class RegistedCartService {
	
	private static final String REGISTED_USER = "RU";
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	public Boolean saveRegistedCart(RegistedCart registedCart) {
		User loginUser = userDao.findByUserName(registedCart.getUsername());
		System.out.println("loginUser :::::"+registedCart.getUsername());
		if (null != loginUser) {
			System.out.println("loginUser :::::"+loginUser.getUserName());
			
			Cart cart = new Cart();
			cart.setAmount(registedCart.getAmount());
			cart.setPizzaName(registedCart.getPizzaName());
			cart.setQuantity(registedCart.getQuantity());
			cart.setUserId(loginUser.getUserName());
			cart.setCartType(REGISTED_USER);
			cart.setOrderDate(Calendar.getInstance().getTime());
			
			
			cartDao.save(cart);
			return true;
		} else {
			return false;
		}
		
	}
}

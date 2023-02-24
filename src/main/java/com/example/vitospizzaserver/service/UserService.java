package com.example.vitospizzaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vitospizzaserver.dao.UserDao;
import com.example.vitospizzaserver.dto.SigninUser;
import com.example.vitospizzaserver.dto.SignupUser;
import com.example.vitospizzaserver.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public Boolean saveSignupUser(SignupUser signupUser) {
		try {
			User user = new User();
			System.out.println("user name ::::"+signupUser.getUsername());
			user.setUserName(signupUser.getUsername());
			user.setAddress(signupUser.getAddress());
			user.setEmail(signupUser.getEmail());
			user.setFirstName(signupUser.getFirstname());
			user.setLastName(signupUser.getLastname());
			user.setPassword(signupUser.getPassword());
			user.setRepassword(signupUser.getPassword());
			user.setPhone(signupUser.getPhone());
			
			userDao.save(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public Boolean validateLoginUser(SigninUser signinUser) {
		try {
			User loginUser = userDao.findByUserName(signinUser.getUsername());
			if (null != loginUser) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
}

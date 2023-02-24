package com.example.vitospizzaserver;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vitospizzaserver.dao.CartDao;
import com.example.vitospizzaserver.dao.UnregisteredUserDao;
import com.example.vitospizzaserver.dao.UserDao;
import com.example.vitospizzaserver.dto.SigninUser;
import com.example.vitospizzaserver.model.UnregisteredUser;
import com.example.vitospizzaserver.model.User;
import com.example.vitospizzaserver.service.UserService;

@SpringBootTest
class VitosPizzaServerApplicationTests {
	
	private static final String USER_NAME = "testuser";
	private static final String PASSWORD = "test";

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UnregisteredUserDao unregisteredUserDao;
	
	@Autowired
	private UserService userService;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	public void checkUser() {
		User user = userDao.findByUserName(USER_NAME);
		Assert.assertEquals("Dreshan",user.getFirstName());
        Assert.assertEquals("Madhuranga",user.getLastName());
		
	}
	
	@Test
	public void checkUnregistedUser() {
		String phoneNumber = "713011665";
		UnregisteredUser unregisteredUser = unregisteredUserDao.findUnregisteredUserByPhone(phoneNumber);
		Assert.assertEquals("Dreshan",unregisteredUser.getFirstName());
        Assert.assertEquals("Madhuranga",unregisteredUser.getLastName());
	}
	
	@Test
	public void validateUser() {
		SigninUser signinUser = new SigninUser();
		signinUser.setUsername(USER_NAME);
		signinUser.setPassword(PASSWORD);
		Boolean status = userService.validateLoginUser(signinUser);
		
		Assert.assertEquals(true,status);
	}
	
}

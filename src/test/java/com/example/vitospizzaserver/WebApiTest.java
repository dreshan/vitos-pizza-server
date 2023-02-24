package com.example.vitospizzaserver;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.vitospizzaserver.controller.LoginUserController;
import com.example.vitospizzaserver.controller.RegistedCartController;
import com.example.vitospizzaserver.controller.SignUpUserController;
import com.example.vitospizzaserver.controller.UnregisteredCartController;
import com.example.vitospizzaserver.dao.CartDao;
import com.example.vitospizzaserver.dao.UnregisteredUserDao;
import com.example.vitospizzaserver.dao.UserDao;



@RunWith(SpringRunner.class)
@WebMvcTest({LoginUserController.class,RegistedCartController.class, SignUpUserController.class, UnregisteredCartController.class})
public class WebApiTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private CartDao cartDao;
	
	@MockBean
	private UnregisteredUserDao unregisteredUserDao;
	
	@MockBean
	private UserDao userDao;
	
	
	@Test
    public void getLoginApi() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
                    .get("/vitospizzaserver/loginUserService")
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
    }
	
	
}

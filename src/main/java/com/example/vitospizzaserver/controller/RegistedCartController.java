package com.example.vitospizzaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitospizzaserver.dto.RegistedCart;
import com.example.vitospizzaserver.service.RegistedCartService;
import com.example.vitospizzaserver.utility.StandardResponse;

@RestController
@RequestMapping("vitospizzaserver")
@CrossOrigin
public class RegistedCartController {
	
	@Autowired
	private RegistedCartService registedCartService;

	@PostMapping("/registedUserwithOrder")
	public ResponseEntity<StandardResponse> saveRegistedUserwithOrder(@RequestBody RegistedCart registedCart) {
		
		Boolean status = registedCartService.saveRegistedCart(registedCart);
		
		if (status) {
			return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Successfully Signup", "Successfully Signup"), HttpStatus.OK);
		} else {
			return new ResponseEntity<StandardResponse>(new StandardResponse(400,"Unsuccessfully Signup", "Unsuccessfully Signup"), HttpStatus.BAD_REQUEST);
		}
		
	}
}

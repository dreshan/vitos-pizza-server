package com.example.vitospizzaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitospizzaserver.dto.UnregisteredCart;
import com.example.vitospizzaserver.service.UnregisteredCartService;
import com.example.vitospizzaserver.utility.StandardResponse;


@RestController
@RequestMapping("vitospizzaserver")
@CrossOrigin(origins = "http://localhost:4200")
public class UnregisteredCartController {
	
	@Autowired
	private UnregisteredCartService unregisteredCartService;

	@PostMapping("/processUnregisteredCart")
	public ResponseEntity<StandardResponse> processUnregisteredCart(@RequestBody UnregisteredCart unregisteredCartCart) {
		unregisteredCartService.processUnregistedCart(unregisteredCartCart);
		return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Successful", "Successful"), HttpStatus.OK);
	}
}

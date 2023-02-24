package com.example.vitospizzaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitospizzaserver.dto.SignupUser;
import com.example.vitospizzaserver.service.UserService;
import com.example.vitospizzaserver.utility.StandardResponse;

@RestController
@RequestMapping("vitospizzaserver/customer")
@CrossOrigin
public class SignUpUserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/signupUserInfor")
	public ResponseEntity<StandardResponse> signupUser(@RequestBody SignupUser signupUser) {
		System.out.println("ResponseEntity ::: "+signupUser.getUsername());
		Boolean status = userService.saveSignupUser(signupUser);
		
		if (status) {
			return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Successfully Signup", "Successfully Signup"), HttpStatus.OK);
		} else {
			return new ResponseEntity<StandardResponse>(new StandardResponse(400,"Unsuccessfully Signup", "Unsuccessfully Signup"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/checkUsernameAvailability")
	public ResponseEntity<StandardResponse> checkUsernameAvailability(@RequestBody String username) {
		Boolean status = false;
		System.out.println("checkUsernameAvailability ::: "+username);
		if (status) {
			return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Successfully Signup", "Successfully Signup"), HttpStatus.OK);
		} else {
			return new ResponseEntity<StandardResponse>(new StandardResponse(400,"Unsuccessfully Signup", "Unsuccessfully Signup"), HttpStatus.BAD_REQUEST);
		}
	}
}

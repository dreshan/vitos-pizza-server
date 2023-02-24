package com.example.vitospizzaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitospizzaserver.dto.SigninUser;
import com.example.vitospizzaserver.service.UserService;
import com.example.vitospizzaserver.utility.StandardResponse;

@RestController
@RequestMapping("vitospizzaserver")
@CrossOrigin
public class LoginUserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/loginUserService")
	public ResponseEntity<StandardResponse> loginUserService(@RequestBody SigninUser signinUser) {
		
		System.out.println("signin user details  ::: "+signinUser.getUsername());
		
		Boolean status = userService.validateLoginUser(signinUser);
		
		System.out.println("status :::::::"+status);
		if (status) {
			return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Successfully Signin", "Successfully Signin"), HttpStatus.OK);
		} else {
			return new ResponseEntity<StandardResponse>(new StandardResponse(400,"Unsuccessfully Signin", "Unsuccessfully Signin"), HttpStatus.BAD_REQUEST);
		}
	}

}

package com.bilgeadam.controller;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.repository.entitiy.User;
import com.bilgeadam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


	UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping

	public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){


		return ResponseEntity.ok(userService.findByUsernameAndPassword(dto));



	}
	@PostMapping("/register")


	public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto){
		//1. etapta -> Auth içinde kayıt olmalı
		userService.saveReturnUser(dto);


		//2. etapta User-Service e kayıt için istek atmalı ve dönen cevaba göre devam etmeli

		return  ResponseEntity.ok().build();
	}
	@GetMapping("/findall")
	public  ResponseEntity<List<User>> findAll(){

		return ResponseEntity.ok(userService.findall());

	}


}

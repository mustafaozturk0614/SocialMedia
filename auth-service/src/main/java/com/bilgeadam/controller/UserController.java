package com.bilgeadam.controller;
import static  com.bilgeadam.constant.RestApiUrls.*;
import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.ProfileRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.manager.ProfileManager;
import com.bilgeadam.repository.entitiy.User;
import com.bilgeadam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(VERSION+USER)
public class UserController {


	UserService userService;
	ProfileManager profileManager;

	@Autowired
	public UserController(UserService userService, ProfileManager profileManager) {
		this.userService = userService;
		this.profileManager = profileManager;
	}

	@PostMapping(DOLOGIN)
	public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
		return ResponseEntity.ok(userService.getProfile(dto));
	}


	@PostMapping(REGISTER)
	public ResponseEntity<String> register(@RequestBody @Valid RegisterRequestDto dto){
		//1. etapta -> Auth içinde kayıt olmalı
	 User user=	userService.saveReturnUser(dto);
		//2. etapta User-Service e kayıt için istek atmalı ve dönen cevaba göre devam etmeli
		//ProfileRequestDto profileRequestDto=mapper.toProfileRequestDto(dto);
		//		profileRequestDto.setAuthId(user.getId());
		//		profileManager.save(profileRequestDto);
	String id=	profileManager.save(ProfileRequestDto.builder().authId(user.getId()).email(dto.getEmail()).firstName(dto.getName()).
				lastName(dto.getSurName()).country(dto.getCountry()).gender(dto.getGender()).city(dto.getCity()).build()).getBody();
		return  ResponseEntity.ok(id);

	}
	@GetMapping(FINDALL)
	public  ResponseEntity<List<User>> findAll(){

		return ResponseEntity.ok(userService.findall());

	}



}

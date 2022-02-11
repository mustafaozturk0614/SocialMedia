package com.bilgeadam.controller;
import static com.bilgeadam.constant.RestApiUrls.*;
import com.bilgeadam.dto.requset.ProfileRequestDto;
import com.bilgeadam.repository.entity.Profile;
import com.bilgeadam.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VERSION+PROFİLE)
@RequiredArgsConstructor
public class ProfileController {

	private  final ProfileService service;


	@PostMapping(SAVE)//("/save")
	public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){

	String id=service.save(dto);
		return ResponseEntity.ok("Ok");


	}
	@GetMapping("getall")
	public ResponseEntity<List<Profile>> findAll(){

		return ResponseEntity.ok(service.findAll());
	}


}
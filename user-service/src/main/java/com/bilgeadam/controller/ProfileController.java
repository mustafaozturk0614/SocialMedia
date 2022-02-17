package com.bilgeadam.controller;
import static com.bilgeadam.constant.RestApiUrls.*;

import com.bilgeadam.dto.requset.FindByAutIdDto;
import com.bilgeadam.dto.requset.ProfileRequestDto;
import com.bilgeadam.rabbitmq.model.ProfileNotification;
import com.bilgeadam.rabbitmq.producer.ElasticProfileProducer;
import com.bilgeadam.repository.entity.Profile;
import com.bilgeadam.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(VERSION+PROFILE)
@RequiredArgsConstructor
public class ProfileController {

	private  final ProfileService service;
	private final ElasticProfileProducer elasticProfileProducer;


	@PostMapping(SAVE)//("/save")
	public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){

		String id = service.save(dto);
		elasticProfileProducer.sendMessageProfileSave(ProfileNotification.builder()
																		 .city(dto.getCity())
																		 .country(dto.getCountry())
																		 .email(dto.getEmail())
																		 .firstname(dto.getFirstName())
																		 .lastname(dto.getLastName())
																		 .profileid(id)
																		 .build());
		return ResponseEntity.ok(id);


	}
	@GetMapping("getall")
	public ResponseEntity<List<Profile>> findAll(){

		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping(FINDBYAUTHID)
	ResponseEntity<String> findByAuthId(@RequestBody @Valid FindByAutIdDto dto){
		Optional<Profile> profile = service.findbyAuthID(dto.getAuthid());
		if(profile.isPresent()){
			return ResponseEntity.ok(profile.get().getId());
		}else{
			return ResponseEntity.ok("");
		}
	}

}

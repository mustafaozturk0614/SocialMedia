package com.bilgeadam.controller;

import static com.bilgeadam.constant.RestApiUrls.*;

import com.bilgeadam.dto.request.FindByAutIdDto;
import com.bilgeadam.dto.request.IsProfileExistDto;
import com.bilgeadam.dto.request.ProfileRequestDto;
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
// @RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    private final ElasticProfileProducer elasticProfileProducer;

    @PostMapping(SAVE)
    // @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){
        String id = profileService.save(dto);
        elasticProfileProducer.sendMessageProfileSave(ProfileNotification.builder()
                        .city(dto.getCity())
                        .country(dto.getCountry())
                        .email(dto.getEmail())
                        .firstname(dto.getFirstname())
                        .lastname(dto.getLastname())
                        .profileid(id)
                .build());
        return ResponseEntity.ok(id);
    }

    @PostMapping(FINDBYAUTHID)
    public ResponseEntity<String> findByAuthId(@RequestBody @Valid FindByAutIdDto dto){
        Optional<Profile> profile = profileService.findByAuthId(dto.getAuthid());
        if(profile.isPresent()){
            return ResponseEntity.ok(profile.get().getId());
        }else{
            return ResponseEntity.ok("");
        }
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Profile>> findAll(){
        return ResponseEntity.ok(profileService.findAll());
    }

    @PostMapping ("/isprofileexistbyid")
    public ResponseEntity<Boolean> isProfileExistById(@RequestBody IsProfileExistDto dto){
        Optional<Profile> profile = profileService.findById(dto.getProfileId());
        if(profile.isPresent()){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }


}

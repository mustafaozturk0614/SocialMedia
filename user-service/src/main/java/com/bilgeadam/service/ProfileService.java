package com.bilgeadam.service;

import com.bilgeadam.dto.requset.ProfileRequestDto;
import com.bilgeadam.mapper.ProfileMapper;
import com.bilgeadam.repository.IProfileRepository;
import com.bilgeadam.repository.entity.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

	private final IProfileRepository repository;
	private final ProfileMapper mapper;
	public  String save(ProfileRequestDto dto){
		Profile profile = mapper.toProfile(dto);
		repository.save(profile);
		return  profile.getId();

	}

	public  void update(Profile profile){

		repository.save(profile);
	}
	public  void delete(Profile profile){

		repository.delete(profile);
	}
	public List<Profile> findAll(){
		return  repository.findAll();

	}

	public Optional<Profile> findbyAuthID   (long id){

		return  repository.findByAuthId(id);


	}

	public Optional<Profile> findbyId   (String id){

		return  repository.findById(id);


	}
}

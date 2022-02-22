package com.bilgeadam.service;

import com.bilgeadam.repository.ILikeRepository;
import com.bilgeadam.repository.ILikeRepository;
import com.bilgeadam.repository.entity.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

	private  final ILikeRepository repository;


	public Like save (Like like){
		return repository.save(like);
	}

	public Like update (Like like){
		return repository.save(like);
	}

	public boolean delete (String id){

		try {
			repository.deleteById(id);
			return true;
		}
		catch (Exception e){
			return false;}
	}

	public List<Like> findAll (){
		return repository.findAll();
	}
}

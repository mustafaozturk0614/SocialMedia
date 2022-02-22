package com.bilgeadam.service;

import com.bilgeadam.repository.IDislikeRepository;
import com.bilgeadam.repository.IDislikeRepository;
import com.bilgeadam.repository.entity.Dislike;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DislikeService {

	private  final IDislikeRepository repository;


	public Dislike save (Dislike dislike){
		return repository.save(dislike);
	}

	public Dislike update (Dislike dislike){
		return repository.save(dislike);
	}

	public boolean delete (String id){

		try {
			repository.deleteById(id);
			return true;
		}
		catch (Exception e){
			return false;}
	}

	public List<Dislike> findAll (){
		return repository.findAll();
	}
}

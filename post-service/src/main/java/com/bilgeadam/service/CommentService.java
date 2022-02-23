package com.bilgeadam.service;

import com.bilgeadam.repository.ICommentRepository;
import com.bilgeadam.repository.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

	private  final ICommentRepository repository;


	public Comment save (Comment comment){
		return repository.save(comment);
	}

	public Comment update (Comment comment){
		return repository.save(comment);
	}

	public boolean delete (String id){

		try {
			repository.deleteById(id);
			return true;
		}
		catch (Exception e){
		return false;}
	}

	public List<Comment> findAll (){
		return repository.findAll();
	}
//	public  List<Comment> findByPostId(){
//		return repository.findByPostId();
//	}



}

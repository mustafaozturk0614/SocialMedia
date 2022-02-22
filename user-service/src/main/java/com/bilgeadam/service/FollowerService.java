package com.bilgeadam.service;

import com.bilgeadam.repository.IFollowRepository;
import com.bilgeadam.repository.IFollowerRepository;
import com.bilgeadam.repository.entity.Follow;
import com.bilgeadam.repository.entity.Follower;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerService {


    private final IFollowerRepository repository;

    public Follower save(Follower follower){
        return repository.save(follower);
    }
    public Follower update(Follower follower){
        return repository.save(follower);
    }
    public boolean delete(String id){
        try {
            repository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public List<Follower> findAll(){
        return repository.findAll();
    }

}

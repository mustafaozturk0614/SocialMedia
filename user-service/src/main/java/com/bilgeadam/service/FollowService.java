package com.bilgeadam.service;

import com.bilgeadam.repository.IFollowRepository;
import com.bilgeadam.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {


    private final IFollowRepository repository;

    public Follow save(Follow follow){
        return repository.save(follow);
    }
    public Follow update(Follow follow){
        return repository.save(follow);
    }
    public boolean delete(String id){
        try {
            repository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public List<Follow> findAll(){
        return repository.findAll();
    }

}

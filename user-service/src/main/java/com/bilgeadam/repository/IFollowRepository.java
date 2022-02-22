package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Follow;
import com.bilgeadam.repository.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFollowRepository extends MongoRepository<Follow,String> {



}

package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IProfileRepository extends MongoRepository<Profile,String> {

	Optional<Profile> findByAuthId( Long id);


}

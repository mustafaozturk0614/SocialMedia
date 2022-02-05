package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProfile extends MongoRepository<Profile,String> {


}

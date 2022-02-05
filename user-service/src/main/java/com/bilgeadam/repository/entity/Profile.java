package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
@Document
public class Profile {
	@Id
	String id;
	long authId;
	String firstName;
	String lastName;
	String email;
	String birthDate;
	String country;
	String city;
	String gender;
	String about;
	List<Interest> ınterest;

	class Education{
		String name;
		int from;
		int to;
		String about;
	}


	class Work{

		String company;
		String designation;
		int from;
		int to;
		String town;
		String decription;


	}
}

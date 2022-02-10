package com.bilgeadam.dto.requset;

import com.bilgeadam.repository.entity.Interest;
import com.bilgeadam.repository.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class ProfileRequestDto {

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
	Profile.Education education;
	Profile.Work work;


	class  Education{

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

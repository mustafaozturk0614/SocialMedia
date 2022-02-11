package com.bilgeadam.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class ProfileRequestDto {


	long authId;
	String firstName;
	String lastName;
	String email;
	String birthDate;
	String country;
	String city;
	String gender;
	String about;

}

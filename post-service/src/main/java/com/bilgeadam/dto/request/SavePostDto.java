package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SavePostDto {

	String userid;
	String username;
	String content;
	String imagename;
	double lat;
	double lng;
	String address;
}

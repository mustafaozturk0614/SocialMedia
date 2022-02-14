package com.bilgeadam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class DoLoginResponseDto {

	String profileId;
	int status;
	/**
	 * 200:Başarılı
	 * 400:
	 * */

	int error;
}

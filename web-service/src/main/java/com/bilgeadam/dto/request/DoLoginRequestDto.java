package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class DoLoginRequestDto {
	@Email(message = "lütfen geçerli bir email adresi giriniz")
	@NotNull(message = "Email adresi boş bırakılamaz")
	String username;
	@NotNull
	@Size(min = 8,max = 32 ,message = "Şifre en az 8 karekter en falz 32 karakter olmalıdır")
	String password;
}

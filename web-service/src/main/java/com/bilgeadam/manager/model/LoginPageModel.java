package com.bilgeadam.manager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class LoginPageModel {
	String title;
	List<Urun> urunler;

	@Data
	@Builder
	public static class Urun{
		String urunAdi;

	}
}

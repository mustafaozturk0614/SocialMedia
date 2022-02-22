package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
/**
 * kullanıcıların aktiflik durumunu ve son aktif olduğu zmanı tutar
 */
public class Online {
	@Id
	String id;
	String userId;
	boolean isActive;
	long lastActiveTime;
}

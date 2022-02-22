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
public class Follow {
	@Id
	String id;
	/*
	takip eden
	 */
	String userId;
	/**
	 * Takip edilen
	 *
	 */
	String followId;


}

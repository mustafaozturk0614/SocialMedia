package com.bilgeadam.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document

/**
 * Beni takip edenler
 */
public class Follower {
	@Id
	String id;

	String userId;

	String follewerId;

}

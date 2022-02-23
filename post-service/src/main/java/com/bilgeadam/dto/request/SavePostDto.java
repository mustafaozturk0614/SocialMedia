package com.bilgeadam.dto.request;

import com.bilgeadam.repository.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SavePostDto {

	String userId;
	String username;
	String content;
	String postmediaurl;
	Post.Location location;




}

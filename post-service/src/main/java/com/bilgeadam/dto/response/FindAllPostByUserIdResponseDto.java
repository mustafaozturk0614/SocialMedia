package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.Comment;
import com.bilgeadam.repository.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindAllPostByUserIdResponseDto {
	String id;
	String username;
	Boolean following;
	String postmediaurl;
	int like;
	int dislike;
	long sharedTime;
	String content;
	List<Comment> comments;


}

package com.bilgeadam.controller;
import com.bilgeadam.dto.request.GetAllPostByUserIdDto;
import com.bilgeadam.dto.request.SavePostDto;
import com.bilgeadam.repository.entity.Post;
import com.bilgeadam.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constans.RestApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION + POST)
public class PostController {
	/**
	 * 1- Post Paylaş
	 * 2- Kullanıcının Paylaşımlarını Getir
	 */
	private final PostService postService;

	/**
	 * Bir Kullanıcıya ait postları getirir
	 * @return
	 */
	@PostMapping(FINDBYUSERID)
	public ResponseEntity<List<Post>> findByUserId(@RequestBody GetAllPostByUserIdDto dto) {
		return ResponseEntity.ok(postService.findByUserId(dto));
	}

	/**
	 * KUllanıcı bir post atmak istediğinde kullanılır.
	 * @param dto -> genel bilgiler alınır. content, userid
	 * @param file -> kullanıcı paylaştığı video ya da fotoğrafı gönderir.
	 * @return -> kayıt edilip edilmediği bilgisi döner.
	 */
	@PostMapping(value = SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> savePost(@RequestBody @Valid SavePostDto dto) {

		try {
			Optional<Post> result = postService.saveDto(dto);
			return ResponseEntity.ok(result.isPresent());
		}catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}
}

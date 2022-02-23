package com.bilgeadam.controller;

import com.bilgeadam.service.MediaService;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.bilgeadam.constans.RestApiUrls.*;

@RestController
@RequestMapping(MEDİA)
@RequiredArgsConstructor
public class MediaController {


	private final MediaService mediaService;

	@Autowired
	Storage storage;

	@PostMapping(value= UPLOADFILE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		Optional<String> result = mediaService.uploadMediaGoogle(file);
		return ResponseEntity.ok(result.get());
	}

}

package com.bilgeadam.manager;

import com.bilgeadam.dto.request.ProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.bilgeadam.constant.RestApiUrls.*;

/**
 * application yml içerisinde localhost:8090 myapplication.userservice içinden çektik
 */
@FeignClient(url ="${myapplication.userservice}"+VERSION+PROFİLE ,name = "profileFeingClient",decode404 = true)
public interface ProfileManager {

	@PostMapping(SAVE)
	public ResponseEntity<String> save(@RequestBody ProfileRequestDto dto);
}

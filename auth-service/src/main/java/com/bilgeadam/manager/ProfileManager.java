package com.bilgeadam.manager;

import com.bilgeadam.dto.request.FindByAuthIdDto;
import com.bilgeadam.dto.request.ProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.bilgeadam.constant.RestApiUrls.*;
import static com.bilgeadam.constant.RestApiUrls.FINDBYAUTHID;

/**
 * application yml içerisinde localhost:8090 myapplication.userservice içinden çektik
 */
@FeignClient(url ="${myapplication.userservice}"+VERSION+PROFILE ,name = "profileFeingClient",decode404 = true)
public interface ProfileManager {

	@PostMapping(SAVE)
	ResponseEntity<String> save(@RequestBody ProfileRequestDto dto);

	@PostMapping(FINDBYAUTHID)
   ResponseEntity<String> findByAuthId(@RequestBody @Valid FindByAuthIdDto dto);

}

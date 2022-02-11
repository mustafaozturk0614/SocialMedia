package com.bilgeadam.controller;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.manager.AuthServiceManager;
import com.bilgeadam.service.S3ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

import static java.rmi.server.LogStream.log;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

	private final AuthServiceManager authServiceManager;
	private final S3ManagerService s3ManagerService;



	@PostMapping ("register")
	public Object register(String firstname, String lastname,String email,String password,String country, MultipartFile picture) {

	ModelAndView modelAndView=new ModelAndView();
String profileId=	 authServiceManager.register(RegisterRequestDto.builder().name(firstname).surName(lastname).country(country).password(password).email(email).build()).getBody();

		try {

		s3ManagerService.putObject(profileId+".png",picture);
			modelAndView.setViewName("login");
		} catch (IOException e) {
			log.error("resim yüklenemedi...: "+e.getMessage());
			modelAndView.setViewName("register");

		}



	return  modelAndView;

}


}

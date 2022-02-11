package com.bilgeadam.controller;

import com.bilgeadam.model.LoginPageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("login")
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
//		List<LoginPageModel.Urun> urun=new ArrayList<>();
//		urun.add(LoginPageModel.Urun.builder().urunAdi("Mustafa").build());
//		urun.add(LoginPageModel.Urun.builder().urunAdi("Öztürk").build());

//		modelAndView.addObject("model", LoginPageModel.builder().title("Üye Oll").urunler(urun).build());

		return modelAndView;
	}



}

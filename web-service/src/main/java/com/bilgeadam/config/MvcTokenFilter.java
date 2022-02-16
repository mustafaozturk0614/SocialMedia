package com.bilgeadam.config;

import com.bilgeadam.dto.request.LoginDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.service.LoginService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * kendine gelen tüm istekleri karşılayacak ve bu isteklere göre bir filter oluşturacak
 * kullanıcı bilgilerini spring auth a verecek
 */
@Component
@Slf4j
public class MvcTokenFilter extends OncePerRequestFilter {

	LoginService service;
	SocialMediaUserDetailService userDetailService;
	@Autowired
	public MvcTokenFilter(LoginService service, SocialMediaUserDetailService userDetailService) {
		this.service = service;
		this.userDetailService = userDetailService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		String username=request.getParameter("email");
		String password=request.getParameter("password");

//		UsernamePasswordAuthenticationToken authenticationToken =
//				new UsernamePasswordAuthenticationToken(userDetailService.loadUserByUsername("bilgeadam")
//						,null,userDetailService.loadUserByUsername("bilgeadam").getAuthorities());
//		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		if(username!=null && password !=null){
			DoLoginResponseDto dto=service.login(LoginDto.builder().email(username).password(password).build());

			if (dto.getError()==200){
				log.info("Giriş başarılı");

			}
			else {
				log.info(dto.toString());
			}
		}






		filterChain.doFilter(request,response);




	}
}

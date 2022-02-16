package com.bilgeadam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MvcTokenFilter mvcTokenFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * Rest api izinlere takılmadan kullanmak için disable ediyoruz,
		 *
		 */
	http.csrf().disable();
		/**
		 * Http isteklerinde kimlik doğrulma işlemlerininin tamamında ,izinleri sorgulama
		 * permitAll() tüm izsteklere izin verir
		 */
//		http.authorizeRequests().anyRequest().permitAll();
		/**
		 *  http://localhosty/register adresine izin verip diğer tüm istekleri izne tabi tutuyoruz
		 */
	http.authorizeRequests().antMatchers("/register","/login").permitAll().anyRequest().authenticated();

		http.formLogin().loginPage("/login").loginProcessingUrl("/login");

		http.addFilterBefore(mvcTokenFilter, UsernamePasswordAuthenticationFilter.class);




	}
}



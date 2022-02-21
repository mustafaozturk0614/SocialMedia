package com.bilgeadam.utility;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.repository.entity.User;

public class UserFactory {

    public static User createUser(){
        User user = new User();
        user.setPassword("123");
        user.setUsername("bilgeadam");
        return user;
    }

    public static DoLoginRequestDto createDoLoginRequestDto(){
        DoLoginRequestDto doLoginRequestDto = new DoLoginRequestDto();
        doLoginRequestDto.setPassword("123");
        doLoginRequestDto.setUsername("bilgeadam");
        return doLoginRequestDto;
    }

    public static RegisterRequestDto createRegisterRequestDto(){
        RegisterRequestDto dto = new RegisterRequestDto();
        dto.setAd("testad");
        dto.setCinsiyet("erkek");
        dto.setEmail("testm@gmail.com");
        dto.setSoyad("test");
        dto.setUlke("Türkiye");
        dto.setSifre("123");
        dto.setYil(1987);
        return dto;
    }

}

package com.bilgeadam.service;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.mapper.UserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.utility.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	private UserService userService;
	@Mock
	IUserRepository iUserRepository;
	@Mock
	UserMapper userMapper;

@Test
public  void testSave(){

	RegisterRequestDto dto=UserFactory.createRegisterRequestDto();
	User user=UserFactory.createUser();
	Mockito.when(userMapper.toUser(ArgumentMatchers.any(RegisterRequestDto.class)));

userService.saveReturnUser(dto);
}

}
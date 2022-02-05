package com.bilgeadam.service;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.mapper.UserMapper;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entitiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


	IUserRepository iUserRepository;
	UserMapper userMapper;
	@Autowired
	public UserService(IUserRepository iUserRepository, UserMapper userMapper) {
		this.iUserRepository = iUserRepository;
		this.userMapper = userMapper;
	}




	/**
	 *
	 * @param dto
	 * @return
	 */

	public User saveReturnUser(RegisterRequestDto dto){
		User user=userMapper.touser(dto);

		return iUserRepository.save(user);
	}

	public void save(User user){
		iUserRepository.save(user);

	}

	public void update(User user){

		iUserRepository.save(user);
	}

	public  void  delete(User user){
		iUserRepository.delete(user);

	}

	public List<User> findall(){

		return iUserRepository.findAll();
	}


	public DoLoginResponseDto findByUsernameAndPassword(DoLoginRequestDto dto){
		Optional<User> user=iUserRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());

		if (user.isPresent()){
			return userMapper.toDoLoginResponseDto(user.get());
		}
		return new DoLoginResponseDto();
	}

	public boolean isUser(String username,String password){

		Optional<User> user=iUserRepository.findByUsernameAndPassword(username,password);
		if(user.isPresent()){
			return true;
		}
		return false;
	}

}

package com.bilgeadam.service;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.FindByAuthIdDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.manager.ProfileManager;
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
	ProfileManager profileManager;
	@Autowired
	public UserService(IUserRepository iUserRepository, UserMapper userMapper,ProfileManager profileManager) {
		this.iUserRepository = iUserRepository;
		this.userMapper = userMapper;
		this.profileManager=profileManager;
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

	public DoLoginResponseDto getProfile(DoLoginRequestDto dto){
		/**
		 * Kullancı adı ve şifre den auth Db de ki kullanıcıyı arar.
		 */
		Optional<User> user =iUserRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		if (user.isPresent()){
			/**
			 * Eğer kullanıvı var ise, ProfileController a giderek kişiye ait profil id sini getirecek.             *
			 */
			long authid = user.get().getId();
			String profileid =   profileManager.findByAuthId(FindByAuthIdDto.builder().authid(authid).build()).getBody();
			/**d
			 * Eğer dönen değer, "" ise farklı dolu ise farklı işlem yapılacak.
			 */
			if (profileid.equals("")){
				return DoLoginResponseDto.builder().error(500).build();
			}else{
				return DoLoginResponseDto.builder().profileId(profileid).error(200).build();
			}
		}
		return DoLoginResponseDto.builder().error(410).build();
	}




}

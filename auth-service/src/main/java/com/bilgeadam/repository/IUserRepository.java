package com.bilgeadam.repository;

import com.bilgeadam.repository.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

	/*
		*Kullanıcının oturum açabilmesi için email ve şifre bilgisi alınır kayıtlı bilgi var ise optinal olarak cevap döner
		* @param username E-mail bilgisi
		* @para password  Şifre bilgisi
		* @return
	 */
	Optional<User> findByUsernameAndPassword  (String username,String password);
	/*
		*Durumlarına göre kullanıcıları listeler
		*@param status
		* @return
	 */
	List<User> findByStatus(int status);
}

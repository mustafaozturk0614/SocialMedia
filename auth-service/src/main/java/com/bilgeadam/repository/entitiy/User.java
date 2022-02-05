package com.bilgeadam.repository.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
@Entity
@Table(name = "tblUser")
public class User {


	@Id
	@SequenceGenerator(name = "sq_tbluser_id",sequenceName = "sq_tbluser_id",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "sq_tbluser_id")
	long id;
	String username;
	String password;
	/*
		status kullanıcın aktiflik durumunu belirtir
		0-> pasif kullanıcı
		1-> aktif kullanıcı
		2-> engellenmiş kullanıcı,hesabı askıda
		3-> v.s
	 */
	int status;
	long createdDate;
	long updateDate;

}

package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.DoLoginResponseDto;
import com.bilgeadam.repository.entitiy.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy =  ReportingPolicy.IGNORE,componentModel = "spring")

public interface UserMapper {



	@Mapping(source = "email",target="username")
	User touser( final RegisterRequestDto dto);

	//Birebir aynı olanların eşleşmesi durumu
	DoLoginResponseDto toDoLoginResponseDto(User user);

}

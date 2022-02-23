package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.SavePostDto;
import com.bilgeadam.dto.response.FindAllPostByUserIdResponseDto;
import com.bilgeadam.repository.entity.Post;
import org.mapstruct.ReportingPolicy;

@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

	Post toPost(SavePostDto dto);

	FindAllPostByUserIdResponseDto toFindAllPostByUserIdResponseDto(Post dto) ;




}

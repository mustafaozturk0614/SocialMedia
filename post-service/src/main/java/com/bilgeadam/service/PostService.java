package com.bilgeadam.service;
import com.bilgeadam.dto.request.GetAllPostByUserIdDto;
import com.bilgeadam.dto.request.SavePostDto;
import com.bilgeadam.dto.response.FindAllPostByUserIdResponseDto;
import com.bilgeadam.mapper.PostMapper;
import com.bilgeadam.repository.ICommentRepository;
import com.bilgeadam.repository.IPostRepository;
import com.bilgeadam.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.net.URL;
import java.util.*;
@Service
@RequiredArgsConstructor
public class PostService {


	private final IPostRepository repository;
	private final S3ManagerService s3ManagerService;
	private final MediaService mediaService;
	private final ICommentRepository iCommentRepository;
	private final PostMapper postMapper;
	public Post save(Post item){
		return repository.save(item);
	}

	public Optional<Post> saveDto(SavePostDto dto){

		Post post=postMapper.toPost(dto);

		return Optional.of(repository.save(post));

	}

	public Post update(Post item){
		return repository.save(item);
	}
	public boolean delete(String id){
		try {
			repository.deleteById(id);
		}catch (Exception e){
			return false;
		}
		return true;
	}
	public List<Post> findAll(){
		return repository.findAll();
	}

	public List<FindAllPostByUserIdResponseDto> findByUserId(GetAllPostByUserIdDto dto){
		List<Post> posts = repository.findByUserId(dto.getUserid());
		List<FindAllPostByUserIdResponseDto> result = new ArrayList<>();
		for (Post post: posts ) {
			String baseUrl =  post.getPostmediaurl();
			Optional<URL> realUrl = mediaService.getGoogleSignedMediaPath(baseUrl,10);
			if(realUrl.isPresent()){
				post.setPostmediaurl(realUrl.get().toString());
			}else
				post.setPostmediaurl("");
			FindAllPostByUserIdResponseDto findAllPostByUserIdResponseDto=
					postMapper.toFindAllPostByUserIdResponseDto(post);
			findAllPostByUserIdResponseDto.setComments(iCommentRepository.findByPostId(post.getId()));

			result.add(findAllPostByUserIdResponseDto);


		}
		return result;
	}
}

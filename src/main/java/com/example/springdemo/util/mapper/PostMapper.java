package com.example.springdemo.util.mapper;

import com.example.springdemo.dto.PostDto;
import com.example.springdemo.dto.responsedto.PostResponseDto;
import com.example.springdemo.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toPost(PostDto postDto);
    List<PostResponseDto> toPostResponseDtos(Page<Post> posts);
}

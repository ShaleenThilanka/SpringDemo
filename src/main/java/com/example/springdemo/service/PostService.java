package com.example.springdemo.service;

import com.example.springdemo.dto.paginateddto.PaginatedPostResponseDto;
import com.example.springdemo.dto.requestdto.PostRequestDto;

public interface PostService {

    String savePost(PostRequestDto dto);

    boolean updatePost(String id, String title);

    boolean deletePost(String propertyId);

    PaginatedPostResponseDto getAllPost(int page, int size, String searchText);
}

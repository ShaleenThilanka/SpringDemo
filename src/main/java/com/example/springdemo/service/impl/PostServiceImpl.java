package com.example.springdemo.service.impl;

import com.example.springdemo.dto.PostDto;
import com.example.springdemo.dto.core.GeneratedIdentificationDTO;
import com.example.springdemo.dto.paginateddto.PaginatedPostResponseDto;
import com.example.springdemo.dto.requestdto.PostRequestDto;
import com.example.springdemo.entity.Post;
import com.example.springdemo.enums.ConsumerType;
import com.example.springdemo.enums.PriorityType;
import com.example.springdemo.exceptions.EntryDuplicationException;
import com.example.springdemo.repo.PostRepo;
import com.example.springdemo.service.PostService;
import com.example.springdemo.util.Generator;
import com.example.springdemo.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private Generator generator;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostMapper postMapper;

    @Override
    public String savePost(PostRequestDto dto) {
        GeneratedIdentificationDTO generatorId = generator.createId();
        ConsumerType consumerType = ConsumerType.valueOf(dto.getConsumerType());
        PriorityType priorityType = PriorityType.valueOf(dto.getPriorityType());
        PostDto postDto = new PostDto(
                generatorId.getPrefix() + "-POST-" + generatorId.getId(),
                dto.getTitle(),
                dto.getKeyword(),
                dto.getShortDescription(),
                dto.getPublishedDate(),
                priorityType,
                dto.getImgUrl(),
                dto.getDescription(),
                consumerType,
                true,
                dto.getOtherData()
        );
        if (!postRepo.existsById(postDto.getPropertyId())) {
            return postRepo.save(postMapper.toPost(postDto)).getPropertyId();
        } else {
            throw new EntryDuplicationException("Already exits");
        }

    }

    @Override
    public boolean updatePost(String id, PostDto dto) {
        Optional<Post> postUpdated = postRepo.findById(id);
        if (postUpdated.isPresent()) {

            postRepo.save(postMapper.toPost(dto));
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(String propertyId) {
        if (postRepo.existsById(propertyId)) {
            postRepo.deleteById(propertyId);
            return true;
        }
        return false;
    }

    @Override
    public PaginatedPostResponseDto getAllPost(int page, int size, String searchText) {
        Page<Post> all = postRepo.getAll(searchText, PageRequest.of(page, size));

        return new PaginatedPostResponseDto(
                postMapper.toPostResponseDtos(all),
                postRepo.countDataCount(searchText)
                );

    }
}

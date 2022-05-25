package com.example.springdemo.controller;


import com.example.springdemo.dto.paginateddto.PaginatedPostResponseDto;
import com.example.springdemo.dto.requestdto.PostRequestDto;
import com.example.springdemo.service.PostService;
import com.example.springdemo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@CrossOrigin
@RequestMapping("api/v1/post")
public class PostController {
    private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;

    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StandardResponse> savePost(@Valid @RequestBody PostRequestDto dto) {
        String savePostId = postService.savePost(dto);
        LOGGER.info("property successfully saved!, Id:" + savePostId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,
                        "Post Saved!",
                        savePostId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/modify", params = {"propertyId", "title"})
    public ResponseEntity<StandardResponse> updatePost(
            @RequestParam(value = "propertyId") String id,
            @RequestParam(value = "title") String title) {
        boolean isUpdated = postService.updatePost(id, title);

        LOGGER.info("property Updated!, Id:" + isUpdated);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,
                        "Post Updated!",
                        isUpdated), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{propertyId}")
    public ResponseEntity<StandardResponse> deletePost(
            @PathVariable String propertyId) {
        boolean isDeleted = postService.deletePost(propertyId);

        LOGGER.info("property Deleted!, Id:" + isDeleted);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,
                        "Post Deleted!",
                        isDeleted), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAll", params = {"page", "size", "searchText"})
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "searchText") String searchText
    ) {
        PaginatedPostResponseDto paginatedPostResponseDto=
                postService.getAllPost(page,size,searchText);

        LOGGER.info("property Deleted!, Id:" + paginatedPostResponseDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,
                        "All post Get!",
                        paginatedPostResponseDto), HttpStatus.CREATED);
    }

}

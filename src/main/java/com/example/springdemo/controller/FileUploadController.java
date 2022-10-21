package com.example.springdemo.controller;


import com.example.springdemo.service.FileUploadService;
import com.example.springdemo.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/file")
@CrossOrigin
public class FileUploadController {
    private final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);
    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<StandardResponse> uploadMultipleFile(
                                                               @RequestParam("file") List<MultipartFile> file) {
        Map<String, Object> fileUrl=fileUploadService.uploadMultipleFile(file);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "File is Successfully Saved", fileUrl),
                HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<StandardResponse> deleteFile(@PathVariable("fileName") String fileName) {
        System.out.println("hello");
        Boolean isDeleted= fileUploadService.deleteFile(fileName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "File is Successfully Deleted!", isDeleted),
                HttpStatus.CREATED);

    }
}

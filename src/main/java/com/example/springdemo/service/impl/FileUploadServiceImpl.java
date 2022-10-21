package com.example.springdemo.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.springdemo.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    private Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Override
    public Map<String, Object> uploadMultipleFile(List<MultipartFile> file) {
        Map<String, Object> map = new HashMap<>();
        File fileObj;
        String fileName = "";
        for (int i = 0; i < file.size(); i++) {
            fileObj = convertMultiPartFileToFile(file.get(i));
            fileName = System.currentTimeMillis() + "_" + file.get(i).getOriginalFilename();
            System.out.println(fileName);
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj).withCannedAcl(CannedAccessControlList.PublicRead));
            fileObj.delete();
            map.put(fileName,s3Client.getUrl(bucketName, fileName));
        }
        return map;
    }

    @Override
    public Boolean deleteFile(String fileName) {

        s3Client.deleteObject(bucketName, fileName);
        return true;
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
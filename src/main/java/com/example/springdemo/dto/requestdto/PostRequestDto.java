package com.example.springdemo.dto.requestdto;

import com.example.springdemo.enums.ConsumerType;
import com.example.springdemo.enums.PriorityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private ArrayList keyword;
    private String shortDescription;
    private Date publishedDate;
    private String priorityType;
    private String imgUrl;
    private ArrayList description;
    private String consumerType;
    private ArrayList otherData;
}

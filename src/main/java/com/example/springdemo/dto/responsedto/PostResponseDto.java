package com.example.springdemo.dto.responsedto;

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
public class PostResponseDto {
    private String title;
    private ArrayList keyword;
    private String shortDescription;
    private Date publishedDate;
    private PriorityType priorityType;
    private String imgUrl;
    private ArrayList description;
    private ConsumerType consumerType;
    private boolean propertyAvailability;
    private ArrayList otherData;
}

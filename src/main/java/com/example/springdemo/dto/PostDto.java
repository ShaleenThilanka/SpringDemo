package com.example.springdemo.dto;

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
public class PostDto {
    private String propertyId;
    private String title;
    private ArrayList keyword;
    private String shortDescription;
    private Date publishedDate;
    private PriorityType priorityType;
    private ArrayList sourceLinks;
    private ArrayList description;
    private ConsumerType consumerType;
    private boolean propertyAvailability;
    private ArrayList otherData;
}
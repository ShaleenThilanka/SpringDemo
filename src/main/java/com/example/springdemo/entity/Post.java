package com.example.springdemo.entity;

import com.example.springdemo.enums.ConsumerType;
import com.example.springdemo.enums.PriorityType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;


import lombok.Data;


import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;


@Entity
@Data
@Table(name = "post")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Post {
    @Id
    @Column(name = "property_id",length = 45)
    private String propertyId;

    @Column(name = "title",length = 250)
    private String title;

    @Type(type = "json")
    @Column(name = "keyword",columnDefinition = "json")
    private ArrayList keyword;

    @Column(name = "short_description", length = 250)
    private String shortDescription;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date publishedDate;

    @Column(name = "priority_type",nullable = false)
    @NotNull(message = "priority type is mandatory")
    @Enumerated(EnumType.STRING)
    private PriorityType priorityType;

    @Type(type = "json")
    @Column(name = "source_links", columnDefinition = "json")
    private ArrayList sourceLinks;

    @Type(type = "json")
    @Column(name = "description", columnDefinition = "json")
    private ArrayList description;

    @Column(name = "consumer_type", nullable = false)
    @NotNull(message = "consumer type is mandatory")
    @Enumerated(EnumType.STRING)
    private ConsumerType consumerType;

    @Column(name = "property_availability", nullable = false,columnDefinition = "TINYINT")
    @NotNull(message = "property availability state is mandatory")
    private boolean propertyAvailability;

    @Type(type = "json")
    @Column(columnDefinition = "json",name = "other_data")
    private ArrayList otherData;

}

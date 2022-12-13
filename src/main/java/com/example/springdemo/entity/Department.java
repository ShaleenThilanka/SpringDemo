package com.example.springdemo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "department")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Department {

    @Id
    @Column(length = 45, name = "department_id")
    private String departmentId;

    @Column(length = 250, name = "department_name")
    private String departmentName;

    @Column(length = 250, name = "department_title")
    private String departmentTitle;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList imageResource;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList webStyles;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList mobileStyles;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList webConfig;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList mobileConfig;


    @Column(name = "active_state", nullable = false, columnDefinition = "TINYINT")
    @NotNull(message = "active state is mandatory")
    private boolean activeState;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList otherData;

    @Column(columnDefinition = "text")
    private String descriptions;


}

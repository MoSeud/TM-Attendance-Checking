package com.redsea.mas.domain;


import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ToString
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String courseId;

    @NotBlank
    private String shortName;

    @NotBlank
     private String description ;

    public Course(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

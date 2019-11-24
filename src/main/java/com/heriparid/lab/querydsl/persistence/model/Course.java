package com.heriparid.lab.querydsl.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    /**
     * Course ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * Course title
     */
    private String name;
    /**
     * ID of the corresponding instructor
     */
    private Long lecturerId;
}

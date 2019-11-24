package com.heriparid.lab.querydsl.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Lecturer {

    /**
     * Lecturer ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
     * Lecturer's name
     */
    private String name;
    /**
     * Gender, true (1) is male, false (0) is female
     */
    private Boolean sex;
}

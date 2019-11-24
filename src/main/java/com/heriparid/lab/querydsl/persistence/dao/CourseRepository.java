package com.heriparid.lab.querydsl.persistence.dao;

import com.heriparid.lab.querydsl.persistence.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CourseRepository extends JpaRepository<Course, Long>, QuerydslPredicateExecutor<Course> {
}

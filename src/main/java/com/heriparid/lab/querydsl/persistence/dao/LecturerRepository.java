package com.heriparid.lab.querydsl.persistence.dao;

import com.heriparid.lab.querydsl.persistence.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface LecturerRepository extends
        JpaRepository<Lecturer,Integer>,
        QuerydslPredicateExecutor<Lecturer> {
}

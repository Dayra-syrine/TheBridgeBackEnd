package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}

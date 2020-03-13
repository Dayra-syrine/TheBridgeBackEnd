package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Cour;



public interface CourRepository  extends JpaRepository<Cour, Long> {

}

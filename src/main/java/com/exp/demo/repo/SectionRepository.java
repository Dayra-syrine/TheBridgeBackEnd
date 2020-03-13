package com.exp.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exp.demo.model.Section;



public interface SectionRepository  extends JpaRepository<Section, Long>  {
	


}

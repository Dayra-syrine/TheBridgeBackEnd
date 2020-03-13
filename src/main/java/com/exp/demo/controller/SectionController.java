package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Cour;
import com.exp.demo.model.Section;
import com.exp.demo.repo.SectionRepository;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/sections")

public class SectionController {
	
	@Autowired
	SectionRepository sr ;
	
	@GetMapping(path="/section", produces = "application/json")
    public List<Section> getSections() 
    {
	  
        return  sr.findAll();
    }
	
	@GetMapping("/section/{id}")
	public List<Section> getSectionByIdCour(@PathVariable(value = "id") Long courId){
		List<Section> section = sr.findAll();
		List<Section> sectionCour=new ArrayList<Section>();
		for(int i=0;i<section.size();i++) {
			if(section.get(i).getCour().getId_C()==courId) {
				sectionCour.add(section.get(i));
			}
		}
		return sectionCour;
	}  

}

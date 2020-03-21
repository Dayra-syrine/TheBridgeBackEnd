package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Cour;
import com.exp.demo.model.Section;
import com.exp.demo.repo.CourRepository;
import com.exp.demo.repo.SectionRepository;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/sections")

public class SectionController {
	
	@Autowired
	SectionRepository sr ;
	
	@Autowired
	CourRepository cr;
	
	@GetMapping(path="/section", produces = "application/json")
    public List<Section> getSections() 
    {
	  
        return  sr.findAll();
    }
	
	@GetMapping("/getsection/{id}")
	public Optional<Section> getSectionByI(@PathVariable(value = "id") Long sectionid){
		return sr.findById(sectionid);
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
	@PostMapping("/section/{id_cour}")
	public Section createSection(@PathVariable Long id_cour, @Valid @RequestBody Section section) {
		Optional<Cour> cour = cr.findById(id_cour);
		section.setCour(cour.get());
		return sr.save(section);

	}

	@PutMapping("/section/{id}")
	public Section updateSection(@PathVariable(value = "id") Long sectionId,
			@Valid @RequestBody Section sectionDetails) {

		Section s = sr.findById(sectionId).get();

		s.setImage(sectionDetails.getImage());
		s.setTitre(sectionDetails.getTitre());

		Section updatedSection = sr.save(s);
		return updatedSection;
	}
	
	@DeleteMapping("/section/{id}")
	public ResponseEntity<HttpStatus> deleteSection(@PathVariable("id") long id) {
		try {
			sr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}

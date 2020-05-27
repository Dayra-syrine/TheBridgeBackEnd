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

import com.exp.demo.model.*;
import com.exp.demo.repo.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/sections")

public class SectionController {

	@Autowired
	SectionRepository sr;
	@Autowired
	VideoRepository vr;
	@Autowired
	CourRepository cr;

	@GetMapping(path = "/section", produces = "application/json")
	public List<Section> getSections() {

		return sr.findAll();
	}

	@GetMapping("/getsection/{id}")
	public Optional<Section> getSectionByI(@PathVariable(value = "id") Long sectionid) {
		return sr.findById(sectionid);
	}

	@GetMapping("/section/{id}")
	public List<Section> getSectionByIdCour(@PathVariable(value = "id") Long courId) {
		List<Section> section = sr.findAll();
		List<Section> sectionCour = new ArrayList<Section>();
		for (int i = 0; i < section.size(); i++) {
			if (section.get(i).getCour().getId_C() == courId) {
				sectionCour.add(section.get(i));
			}
		}
		return sectionCour;
	}

	@GetMapping("/getFirstVideo/{id}")
	public Long getFirstVideo(@PathVariable(value = "id") Long courId) {
		List<Section> section = sr.findAll();
		Long id_section=null;
		Long id_video = null;
		for (int i = 0; i < section.size(); i++) {
			if (section.get(i).getCour().getId_C() == courId) {
				 id_section=section.get(i).getId_S();
				 break;
			}
		}
		List<Video>lv=vr.findAll();
		for(int i=0;i<lv.size();i++) {
			if(lv.get(i).getSection().getId_S()==id_section&& lv.get(i).getOrd()==1) {
				id_video=lv.get(i).getId_V();
			}
		}
		return id_video;
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

	//	s.setImage(sectionDetails.getImage());
		s.setTitre(sectionDetails.getTitre());

		Section updatedSection = sr.save(s);
		return updatedSection;
	}
	
	@PutMapping("/sectionImage/{id}")
	public Section updateImage(@PathVariable(value = "id") Long sectionId,
			@Valid @RequestBody String image) {

		Section s = sr.findById(sectionId).get();

		s.setImage(image);


		Section updatedImage = sr.save(s);
		return updatedImage;
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

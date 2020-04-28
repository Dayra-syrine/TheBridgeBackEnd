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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/cours")
public class CourController {

	@Autowired
	CourRepository cr;
	@Autowired
	SectionRepository sr;

	@GetMapping(path = "/cour/getidCours/{id}", produces = "application/json")
	public Optional<Cour> getCourById(@PathVariable(value = "id") Long courId) {
		return cr.findById(courId);
	}

	@GetMapping(path = "/cour", produces = "application/json")
	public List<Cour> getCours() {

		return cr.findAll();
	}

	@PostMapping(value = "/cour", consumes = "application/json", produces = "application/json")
	public void addCour(@RequestBody Cour cour) {

		cr.save(cour);
	}

	@GetMapping("/cour/{id}")
	public List<Section> getSectionByCoursId(@PathVariable(value = "id") Long courId) {
		List<Section> ls = sr.findAll();
		List<Section> nls = new ArrayList<Section>();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getCour().getId_C() == courId) {
				nls.add(ls.get(i));
			}

		}
		return ls;
	}

	@DeleteMapping("/cour/{id}")
	public ResponseEntity<HttpStatus> deleteCour(@PathVariable("id") long id) {
		try {
			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/cour/{id}")
	public Cour updateCour(@PathVariable(value = "id") Long courId, @Valid @RequestBody Cour courDetails) {

		Cour cour = cr.findById(courId).get();

		cour.setTitre(courDetails.getTitre());
		cour.setDescription(courDetails.getDescription());
		cour.setPrix(courDetails.getPrix());
		cour.setImage(courDetails.getImage());
		cour.setVideo(courDetails.getVideo());
		cour.setDescV(courDetails.getDescV());

		Cour updatedCour = cr.save(cour);
		return updatedCour;
	}

}

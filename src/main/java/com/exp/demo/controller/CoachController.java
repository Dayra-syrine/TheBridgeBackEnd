package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Coach;
import com.exp.demo.model.CoachEtatEnum;
import com.exp.demo.repo.CoachRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/coach")
public class CoachController {

	@Autowired
	private CoachRepository cr;

	List<CoachEtatEnum> etat=new ArrayList<CoachEtatEnum>();
	
	@PostMapping(value = "/signup", produces = "application/json")
	public void addUsers(@RequestParam String fname, @RequestParam String lname, @RequestParam String desc,
			@RequestParam String email, @RequestParam String adresse, @RequestParam String domaine,
			@RequestParam String cvfile, @RequestParam String fcbkaccount,
			@RequestParam String linkedinaccount,@RequestParam String image) {
		List<CoachEtatEnum> etat=new ArrayList<CoachEtatEnum>();
		Coach c = new Coach();
		c.setFirstname(fname);
		c.setLastname(lname);
		c.setEmail(email);
		c.setAdress(adresse);
		c.setDescription(desc);
		c.setDomaine(domaine);
		c.setLinkedinaccount(linkedinaccount);
		c.setFacebookaccount(fcbkaccount);
		c.setCvfile(cvfile);
		c.setPicture(image);
		etat.add(CoachEtatEnum.WAITING);
		c.setEtat(etat);
		cr.save(c);
	}

	@GetMapping(path = "/coach", produces = "application/json")
	public List<Coach> getCoach() {
		return cr.findAll();
	}
	@GetMapping(path = "/coach/{id}", produces = "application/json")
	public Coach getCoachById(@PathVariable(value = "id") Long Id) {
		return cr.findById(Id).get();
	}
	@DeleteMapping("/coach/{id}")
	public ResponseEntity<HttpStatus> deleteCoach(@PathVariable("id") long id) {
		try {
			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping(path = "/coachavailable", produces = "application/json")
	public List<Coach> getCoachAvailable() {
		List<CoachEtatEnum> etat=new ArrayList<CoachEtatEnum>();
		List<Coach> list=cr.findAll();
		etat.add(CoachEtatEnum.ACCEPTED);

		List<Coach> listAvailable= new ArrayList<Coach>();
		for(int i=0;i<list.size();i++) 
		{if(list.get(i).getEtat()==etat) {
			listAvailable.add(list.get(i));
		}
			
		}
		return listAvailable;
	}
	@PutMapping("/acceptCoach/{id}")
	public void acceptCoach(@PathVariable("id") long id) {
		List<CoachEtatEnum> etat=new ArrayList<CoachEtatEnum>();
		Coach c = cr.findById(id).get();
		etat.add(CoachEtatEnum.ACCEPTED);

		c.setEtat(etat);
		cr.save(c);
	}
	@PutMapping("/refuseCoach/{id}")
	public void refuseCoach(@PathVariable("id") long id) {
		List<CoachEtatEnum> etat=new ArrayList<CoachEtatEnum>();
		Coach c = cr.findById(id).get();
		etat.add(CoachEtatEnum.REFUSED);

		c.setEtat(etat);
		cr.save(c);
	}
}

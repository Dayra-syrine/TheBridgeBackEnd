package com.exp.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exp.demo.model.*;
import com.exp.demo.repo.CourRepository;
import com.exp.demo.repo.RegistrationRepository;
import com.exp.demo.repo.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {
	@Autowired
	RegistrationRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	CourRepository cr;

	@PostMapping(path = "/registration", produces = "application/json")
	public String add(@RequestParam long id_user, @RequestParam long id_cours) {
		Registration r = new Registration();
		User user = ur.findById(id_user).get();
		Cour cours = cr.findById(id_cours).get();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		cours.setIsncription_date(dtf.format(localDate));
		r.setCours(cours);
		r.setUser(user);
		rr.save(r);
		return "Saved";
	}

	@GetMapping(path = "/registration/{id}")
	public List<Cour> getListCourByIdUser(@PathVariable(value = "id") Long userId) {
		List<Cour> listCours = new ArrayList<Cour>();
		List<Registration> listrr = rr.findAll();
		List<Registration> listeRegByUser = new ArrayList<Registration>();
		for (int i = 0; i < listrr.size(); i++) {
			if (listrr.get(i).getUser().getId_U() == userId) {
				listeRegByUser.add(listrr.get(i));
			}
		}
		for (int j = 0; j < listeRegByUser.size(); j++) {
			listCours.add(listeRegByUser.get(j).getCours());
		}
		return listCours;
	}

	@GetMapping(path = "/registration", produces = "application/json")
	public boolean coursExistInUserList(@RequestParam long id_user, @RequestParam long id_cours) {
		boolean ok = false;
		List<Registration> listrr = rr.findAll();
		for (int i = 0; i < listrr.size(); i++) {
			if (listrr.get(i).getCours().getId_C() == id_cours && listrr.get(i).getUser().getId_U()==id_user) {
				ok=true;

			}
		}
		return ok;
	}

}

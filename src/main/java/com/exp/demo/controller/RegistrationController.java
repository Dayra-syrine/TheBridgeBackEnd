package com.exp.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exp.demo.model.*;
import com.exp.demo.repo.CourRepository;
import com.exp.demo.repo.HistoriqueRepository;
import com.exp.demo.repo.RegistrationRepository;
import com.exp.demo.repo.SectionRepository;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.repo.VideoRepository;

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

	@Autowired
	SectionRepository sr;

	@Autowired
	VideoRepository vr;

	@Autowired
	HistoriqueRepository hr;

	@PostMapping(path = "/registration", produces = "application/json")
	public String add(@RequestParam long id_user, @RequestParam long id_cours) {
		Registration r = new Registration();

		User user = ur.findById(id_user).get();
		Cour cours = cr.findById(id_cours).get();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();

		r.setIsncription_date(dtf.format(localDate));
		r.setCours(cours);
		r.setUser(user);

		rr.save(r);
		return "Saved";

	}

	@GetMapping(path = "/registration/{id}")
	public List<Registration> getListCourByIdUser(@PathVariable(value = "id") Long userId) {
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
		return listeRegByUser;
	}

	/*
	 * @GetMapping(path = "/registration", produces = "application/json") public
	 * boolean coursExistInUserList(@RequestParam long id_user, @RequestParam long
	 * id_cours) { boolean ok = false; List<Registration> listrr = rr.findAll(); for
	 * (int i = 0; i < listrr.size(); i++) { if (listrr.get(i).getCours().getId_C()
	 * == id_cours && listrr.get(i).getUser().getId_U()==id_user) { ok=true;
	 * 
	 * } } return ok; }
	 */

	@GetMapping(path = "/registration", produces = "application/json")
	public Registration coursExistInUserList(@RequestParam long id_user, @RequestParam long id_cours) {

		List<Registration> listrr = rr.findAll();
		for (int i = 0; i < listrr.size(); i++) {
			if (listrr.get(i).getCours().getId_C() == id_cours && listrr.get(i).getUser().getId_U() == id_user) {
				return listrr.get(i);

			}
		}
		return null;
	}

	List<Video> lvs = new ArrayList<Video>();

	@GetMapping(path = "/VideoSeen", produces = "application/json")
	public Boolean videoSeen(@RequestParam long idU, @RequestParam long idC, @RequestParam long idV) {

		List<Registration> r1 = rr.findAll();
		List<Registration> r2 = new ArrayList<Registration>();
		Boolean add = false;
		Boolean exist = false;

		List<Historique> lh = hr.findAll();

		if (lh.size() == 0) {

			Historique h = new Historique();
			// h.setCours(cr.findById(idC).get());
			h.setUser(ur.findById(idU).get());
			h.setVideo(vr.findById(idV).get());
			hr.save(h);
			add = true;
		} else {
			for (int k = 0; k < lh.size(); k++) {
				if ((lh.get(k).getVideo().getId_V() == idV) && (lh.get(k).getUser().getId_U() == idU)) {
					exist = true;
					break;
				} else {
					Historique hh = new Historique();
					// hh.setCours(cr.findById(idC).get());
					hh.setUser(ur.findById(idU).get());
					hh.setVideo(vr.findById(idV).get());
					hr.save(hh);
					add = true;
				}
			}
		}

		return exist;

	}

	@GetMapping(path = "/increment", produces = "application/json")
	public Boolean increment(@RequestParam long idU, @RequestParam long idC, @RequestParam long idV) {

		List<Registration> r1 = rr.findAll();
		List<Registration> r2 = new ArrayList<Registration>();
		Boolean add = false;

		int nbr = 0;

		List<Section> ls = sr.findAll();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getCour().getId_C() == idC) {
				nbr = nbr + ls.get(i).getVideo().size();

			}
		}

		for (int i = 0; i < r1.size(); i++) {
			if ((r1.get(i).getCours().getId_C() == idC) && (r1.get(i).getUser().getId_U() == idU)) {
					
				int VS = r1.get(i).getVideo_seen() + 1;
				int percentage = (VS * 100) / nbr;
				r1.get(i).setVideo_seen(VS);
				r1.get(i).setPercentage(percentage);
				r1.get(i).setTotal_video(nbr);
				add = true;
				rr.save(r1.get(i));
				r2.add(r1.get(i));

			}
		}

		return add;

	}

	@GetMapping(path = "/ListVideoSeen", produces = "application/json")
	public List<Video> listVideoSeen(@RequestParam long idU) {

		
		List<Historique> lh = hr.findAll();
		List<Video> lv = new ArrayList<Video>();
		
		

		for (int i = 0; i < lh.size(); i++) {

			if (lh.get(i).getUser().getId_U() == idU) {
				lv.add(lh.get(i).getVideo());
			}

		}
		
	

		return lv;
	}
	@GetMapping(path = "/verifVideoSeen", produces = "application/json")
	public Boolean verifVideoSeen(@RequestParam long idU, @RequestParam long idV) {

		Video video = vr.findById(idV).get();
		List<Historique> lh = hr.findAll();
		List<Video> lv = new ArrayList<Video>();
		
		Boolean checked=false;

		for (int i = 0; i < lh.size(); i++) {

			if (lh.get(i).getUser().getId_U() == idU) {
				lv.add(lh.get(i).getVideo());
			}

		}
		
		
		for (int k = 0; k < lv.size(); k++) {
			if (lv.get(k).getId_V() == idV)  {
				
				checked=true;
				
				break;
			}}

		return checked;
	}

}

package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Commentaire;
import com.exp.demo.model.Reply;
import com.exp.demo.model.User;
import com.exp.demo.repo.CommentaireRepository;
import com.exp.demo.repo.ReplyRepository;
import com.exp.demo.repo.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/replys")
public class ReplyController {

	@Autowired
	CommentaireRepository cr;
	@Autowired
	ReplyRepository rr;
	@Autowired
	private UserRepository ur;

	@GetMapping("/getreply/{id}")
	public Optional<Reply> getSectionByI(@PathVariable(value = "id") Long id) {
		return rr.findById(id);
	}

	@GetMapping("/reply/{id}")
	public List<Reply> getReplyByIdCommentaire(@PathVariable(value = "id") Long id) {
		List<Reply> replys = rr.findAll();
		List<Reply> Replycommentaire = new ArrayList<Reply>();
		for (int i = 0; i < replys.size(); i++) {
			if (replys.get(i).getCommentaire().getId_Com() == id) {
				Replycommentaire.add(replys.get(i));
			}
		}
		return Replycommentaire;
	}

	@PostMapping(value = "/reply", produces = "application/json")
	public void addCommentaire(@RequestParam Long id_commentaire, @RequestParam String desc, @RequestParam Long idU) {
		Reply r = new Reply();
		Optional<Commentaire> c = cr.findById(id_commentaire);
		Optional<User> u = ur.findById(idU);
		r.setCommentaire(c.get());
		r.setUser(u.get());
		r.setDesccom(desc);
		rr.save(r);
	}

}

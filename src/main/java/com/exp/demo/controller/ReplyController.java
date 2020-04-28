package com.exp.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Commentaire;
import com.exp.demo.model.Reply;
import com.exp.demo.repo.CommentaireRepository;
import com.exp.demo.repo.ReplyRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/replys")
public class ReplyController {
	
	@Autowired
	CommentaireRepository cr;
	@Autowired
	ReplyRepository rr;
	
	@GetMapping("/getreply/{id}")
	public Optional<Reply> getSectionByI(@PathVariable(value = "id") Long id){
		return rr.findById(id);
	}
	
	
	@GetMapping("/reply/{id}")
	public List<Reply> getReplyByIdCommentaire(@PathVariable(value = "id") Long id){
		List<Reply> replys = rr.findAll();
		List<Reply> Replycommentaire=new ArrayList<Reply>();
		for(int i=0;i<replys.size();i++) {
			if(replys.get(i).getCommentaire().getId_Com()==id) {
				Replycommentaire.add(replys.get(i));
			}
		}
		return Replycommentaire;
	}  
	
	@PostMapping(value = "/reply/{id_commentaire}", consumes = "application/json", produces = "application/json")
    public void addCommentaire(@PathVariable Long id_commentaire, @Valid @RequestBody Reply reply) {
	 Optional<Commentaire> c = cr.findById(id_commentaire);	
	 reply.setCommentaire(c.get());
         rr.save(reply);
    }

}

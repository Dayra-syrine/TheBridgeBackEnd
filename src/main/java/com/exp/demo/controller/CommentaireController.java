package com.exp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Commentaire;
import com.exp.demo.repo.CommentaireRepository;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping(path="/commentaires")
public class CommentaireController {
	@Autowired
	CommentaireRepository cr;
	
	
	@GetMapping(path="/commentaire", produces = "application/json")
    public List<Commentaire> getVideos() 
    {return  cr.findAll();}
	
	 @PostMapping(value = "/commentaire", consumes = "application/json", produces = "application/json")
	    public void addCommentaire(@RequestBody Commentaire commentaire ) {
	         cr.save(commentaire);
	    }
	
}

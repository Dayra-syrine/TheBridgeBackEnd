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
import com.exp.demo.model.Video;
import com.exp.demo.repo.CommentaireRepository;
import com.exp.demo.repo.VideoRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/commentaires")
public class CommentaireController {
	@Autowired
	CommentaireRepository cr;

	@Autowired
	VideoRepository vr;
	
	@GetMapping(path="/commentaire", produces = "application/json")
    public List<Commentaire> getListCommentaire() 
    {return  cr.findAll();}
	
	@GetMapping(path="/commentaire/{id}", produces = "application/json")
    public List<Commentaire> getListCommentaireparVideo(@PathVariable(value = "id") Long videoId) 
    {
		List<Commentaire> ListC = cr.findAll();
		List<Commentaire> ListCparV = new ArrayList<Commentaire>();
		ListC=getListCommentaire();
		for(int i=0;i<ListC.size();i++) {
			if(ListC.get(i).getVideo().getId_V()==videoId) 
			{
				ListCparV.add(ListC.get(i));
			}
			
		}
		return ListCparV;
    }
	
	@GetMapping("/getCommentaire/{id}")
	public Optional<Commentaire> getSectionByI(@PathVariable(value = "id") Long id){
		return cr.findById(id);
	}
		
	
	 @PostMapping(value = "/commentaire/{id_v}", consumes = "application/json", produces = "application/json")
	    public void addCommentaire(@PathVariable Long id_v, @Valid @RequestBody Commentaire commentaire) {
		 Optional<Video> v = vr.findById(id_v);	
		 commentaire.setVideo(v.get());
	         cr.save(commentaire);
	    }
	
}

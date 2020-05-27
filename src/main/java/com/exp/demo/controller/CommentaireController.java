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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.demo.model.Commentaire;
import com.exp.demo.model.User;
import com.exp.demo.model.Video;
import com.exp.demo.repo.CommentaireRepository;
import com.exp.demo.repo.UserRepository;
import com.exp.demo.repo.VideoRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/commentaires")
public class CommentaireController {
	@Autowired
	CommentaireRepository cr;

	@Autowired
	VideoRepository vr;
	
	@Autowired
	private UserRepository ur;
	
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
		
	
	 @PostMapping(value = "/commentaire", produces = "application/json")
	    public Commentaire addCommentaire(@RequestParam Long id_v, @RequestParam String desc , @RequestParam Long idU) {
		 Optional<Video> v = vr.findById(id_v);	
		 Optional<User> u = ur.findById(idU);
		
		 Commentaire com = new Commentaire();
		 com.setVideo(v.get());
		 com.setUser(u.get());
		 com.setDesccom(desc);
		 
	         cr.save(com);
	         return com;
	    }
	
}

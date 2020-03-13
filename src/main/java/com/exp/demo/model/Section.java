package com.exp.demo.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="section")

public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_S;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne          
	@JsonIgnore
	@JoinColumn(name="id_cour")
	private Cour cour;
	
	
	@OneToMany(mappedBy = "section",cascade = CascadeType.ALL)   
	private Set<Video> video;
	
	
	
	public Section() {
		super();
	}
	
	public Section(Long id,String titre,String img) {
		super();
		this.id_S=id;
		this.titre=titre;
		this.image=img;
	}
	
	public Section(String titre,String img,Cour cour) {
		super();
	
		this.titre=titre;
		this.image=img;
		this.cour=cour;
		
		
	}

	public Set<Video> getVideo() {
		return video;
	}

	public void setVideo(Set<Video> video) {
		this.video = video;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public Cour getCour() {
		return cour;
	}

	public void setCour(Cour cour) {
		this.cour = cour;
	}



	public long getId_S() {
		return id_S;
	}

	public void setId_S(long id_S) {
		this.id_S = id_S;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	
	
	
	
}

package com.exp.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="cours")

public class Cour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_C;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "description")
	private String description;

	@Column(name = "prix")
	private String prix;

	@Column(name = "image")
	private String image;
	
	@Column(name = "video")
	private String video;
	
	@Column(name = "descV")
	private String descV;
	
	@Column(name = "courslink")
	private String courslink;
	
	@Column(name = "isncription_date")
	private String isncription_date;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
    private List<Registration> registration ;
	
	
	

	@OneToMany(mappedBy = "cour",cascade = CascadeType.ALL)   
	private Set<Section> lsection;
	
	
	

	public Cour()
	{
		super();
	}
	

	
	public Cour(long id_C,String link, String titre, String description, String prix, String image, String video, String descV,
			Set<Section> lsection) {
		super();
		this.id_C = id_C;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.video = video;
		this.descV = descV;
		this.lsection = lsection;
		this.courslink=link;
	}
	
	public Cour(String link, String titre, String description, String prix, String video, String descV,
			Set<Section> lsection) {
		super();
	
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.video = video;
		this.descV = descV;
		this.lsection = lsection;
		this.courslink=link;
	}
	public Cour(String link,String titre, String description, String prix, String image, String video, String descV) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.video = video;
		this.descV = descV;
		this.courslink=link;
	}

	public Cour(String titre, String description, String prix, String image, String video, String descV) {
		super();
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.video = video;
		this.descV = descV;
	}

	public long getId_C() {
		return id_C;
	}

	public void setId_C(long id_C) {
		this.id_C = id_C;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<Section> getLsection() {
		return lsection;
	}

	public void setLsection(Set<Section> lsection) {
		this.lsection = lsection;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getDescV() {
		return descV;
	}

	public void setDescV(String descV) {
		this.descV = descV;
	}

	public String getCoursLink() {
		return courslink;
	}

	public void setCoursLink(String coursLink) {
		this.courslink = coursLink;
	}
	
	
	public String getIsncription_date() {
		return isncription_date;
	}

	public void setIsncription_date(String isncription_date) {
		this.isncription_date = isncription_date;
	}

	public List<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}
	
	
	
}

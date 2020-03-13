package com.exp.demo.model;

import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="cours")

public class Cour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_C;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "description")
	private String desc;

	@Column(name = "prix")
	private String prix;

	@Column(name = "image")
	private String img;
	
	@Column(name = "video")
	private String url;
	
	@Column(name = "descV")
	private String dv;
	
	
	
	@OneToMany(mappedBy = "cour",cascade = CascadeType.ALL)   
	private Set<Section> lsection;
	
	
	public Set<Section> getLsection() {
		return lsection;
	}

	public void setLsection(Set<Section> lsection) {
		this.lsection = lsection;
	}

	public Cour()
	{
		super();
	}
	
	public Cour(Long id,String titre,String desc,String prix,String img,String url,String dv)
	{
		super();
		this.id_C=id;
		this.titre=titre;
		this.desc=desc;
		this.prix=prix;
		this.img=img;
		this.url=url;
		this.dv=dv;
	}
	
	public Cour(String titre,String desc,String prix,String img,String url,String dv)
	{
		super();
		
		this.titre=titre;
		this.desc=desc;
		this.prix=prix;
		this.img=img;
		this.url=url;
		this.dv=dv;
		
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}

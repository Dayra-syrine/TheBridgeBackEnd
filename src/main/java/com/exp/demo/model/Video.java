package com.exp.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="videos")

public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_V;
	
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "duré")
	private String dure;

	@Column(name = "url")
	private String url;
	
	@ManyToOne          
	@JsonIgnore
	@JoinColumn(name="id_section")
	private Section section;
	
	public Video() {
		super();
	}
	
	public Video(String desc,String url,String img,String dure,Section section) {
		super();
		this.desc=desc;
		this.url=url;
		this.image=img;
		this.dure=dure;
		this.section=section;
	}
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Video(String desc,String url,String img,String dure) {
		super();
		this.desc=desc;
		this.url=url;
		this.image=img;
		this.dure=dure;
	}
	
	

	

	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	

	public long getId_V() {
		return id_V;
	}

	public void setId_V(long id_V) {
		this.id_V = id_V;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	
}

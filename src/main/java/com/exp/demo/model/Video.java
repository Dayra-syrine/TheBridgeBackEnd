package com.exp.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "videos")

public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_V;

	@Column(name = "ordre")
	private int ord;

	@Column(name = "videolink")
	private String videolink;

	@Column(name = "description")
	private String desc;

	@Column(name = "image")
	private String image;

	@Column(name = "duré")
	private String dure;

	@Column(name = "url")
	private String url;
	
	@Column(name = "seen_state")
	private Boolean seen_state;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_section")
	private Section section;

	public Video() {
		super();
	}

	public Video(String desc, String url, String img, String dure, Section section) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.section = section;
	}

	

	public Video(String desc, String url, String img, String dure) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
	}
	public Video(String desc, String url, String img, String dure,String videolink) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.videolink=videolink;
	}
	public Video(String desc, String url, String img, String dure, int ord, Section section) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.ord = ord;
		this.section = section;
	
	}

	public Video(String desc, String url, String img, String dure, int ord, Section section,Boolean seen_state) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.ord = ord;
		this.section = section;
		this.seen_state=seen_state;
	}
	public Video(String desc, String url, String img, String dure, int ord, Section section,String videolink) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.ord = ord;
		this.section = section;
		this.videolink=videolink;
	}
	
	public Video(String desc, String url, String img, String dure, int ord, Section section,String videolink,Boolean seen_state) {
		super();
		this.desc = desc;
		this.url = url;
		this.image = img;
		this.dure = dure;
		this.ord = ord;
		this.section = section;
		this.videolink=videolink;
		this.seen_state=seen_state;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
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

	public String getVideoLink() {
		return videolink;
	}

	public void setVideoLink(String videoLink) {
		this.videolink = videoLink;
	}
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getVideolink() {
		return videolink;
	}

	public void setVideolink(String videolink) {
		this.videolink = videolink;
	}

	public Boolean getSeen_state() {
		return seen_state;
	}

	public void setSeen_state(Boolean seen_state) {
		this.seen_state = seen_state;
	}
	

}

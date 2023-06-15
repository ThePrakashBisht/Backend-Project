package com.movies.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {
	
	@Id
	@Column(length = 40)
	private String tconst;
	
	private String titletype;
	private String primarytitle;
	private int runtimeminutes;
	private String genres;
	
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	
	public String getTitletype() {
		return titletype;
	}
	public void setTitletype(String titletype) {
		this.titletype = titletype;
	}
	public String getPrimarytitle() {
		return primarytitle;
	}
	public void setPrimarytitle(String primarytitle) {
		this.primarytitle = primarytitle;
	}
	public int getRuntimeminutes() {
		return runtimeminutes;
	}
	public void setRuntimeminutes(int runtimeminutes) {
		this.runtimeminutes = runtimeminutes;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	
}

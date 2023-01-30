package com.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Note {

	@Id
	private int id;
	private String title;
	private String content;
	private Date addeedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddeedDate() {
		return addeedDate;
	}
	public void setAddeedDate(Date addeedDate) {
		this.addeedDate = addeedDate;
	}
	public Note(int id, String title, String content, Date addeedDate) {
		super();
		this.id = new Random().nextInt(1000);
		this.title = title;
		this.content = content;
		this.addeedDate = addeedDate;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

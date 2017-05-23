package com.bbg.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private Long id;
	private String text;
	private String author;
	private Date createdOn;
	
	public Message(){
		
	}
	
	public Message(Long id, String text, String author) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
		this.createdOn = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", author=" + author + ", createdOn=" + createdOn + "]";
	}
}

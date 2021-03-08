package org.oday.Messanger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
@XmlRootElement
public class Message {
	
	private Long id;
	private String message;
	private Date created;
	private String auther;
	private Map<Long,Comment>comments=new HashMap<Long,Comment>();
	public Message() {
		super();
	}
	public Message(Long id, String message, String auther) {
		super();
		this.id = id;
		this.message = message;
		this.auther = auther;
		this.created=new Date();
		this.comments.put(1l, new Comment(1l, "COmment 1","Oday"));
		this.comments.put(2l, new Comment(2l, "COmment 2","Oday"));
		this.comments.put(3l, new Comment(3l, "COmment 3","Oday"));
		this.comments.put(4l, new Comment(4l, "COmment 4","Oday"));
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	//@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	

}

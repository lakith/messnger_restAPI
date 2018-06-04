package org.arimac.jax.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Messagemodel {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> linklist = new ArrayList<Link>();
	
	
	
	public Messagemodel(long id, String message, Date created, String author,
			Map<Long, Comment> comments, List<Link> linklist) {
		super();
		this.id = id;
		this.message = message;
		this.created = created;
		this.author = author;
		this.comments = comments;
		this.linklist = linklist;
	}
	
	

	public Messagemodel(String message, Date created, String author,
			Map<Long, Comment> comments, List<Link> linklist) {
		super();
		this.message = message;
		this.created = created;
		this.author = author;
		this.comments = comments;
		this.linklist = linklist;
	}



	public Messagemodel(long id, String message, String author,
			Map<Long, Comment> comments, List<Link> linklist) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.comments = comments;
		this.linklist = linklist;
	}



	public Messagemodel(String message, String author,
			Map<Long, Comment> comments, List<Link> linklist) {
		super();
		this.message = message;
		this.author = author;
		this.comments = comments;
		this.linklist = linklist;
	}



	public List<Link> getLinklist() {
		return linklist;
	}

	public void setLinklist(List<Link> linklist) {
		this.linklist = linklist;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public Messagemodel(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public Messagemodel(String message, String author,Date created) {
		this.message = message;
		this.author = author;
		this.created = created;
	}

	public Messagemodel(String message, String author) {
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public Messagemodel(long id, String message, String author, Date created) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = created;
	}
	
	public Messagemodel(){}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void addLink(String url,String rel){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		linklist.add(link);
	}
	
}

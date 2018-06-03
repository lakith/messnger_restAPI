package org.arimac.jax.messenger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public class MessengerfilterBean {
	
	private @QueryParam("year") int year;
	private @QueryParam("size") int size;
	private @QueryParam("start") int start;
	
	
	public MessengerfilterBean(){}
	
	
	public MessengerfilterBean(int year, int size, int start) {
	
		this.year = year;
		this.size = size;
		this.start = start;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	
	

}

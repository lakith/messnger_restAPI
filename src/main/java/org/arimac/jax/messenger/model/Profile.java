package org.arimac.jax.messenger.model;

import java.util.Date;

public class Profile {

	private long id;
	private String firstname;
	private String lastname;
	private String profilename;
	private Date created;
	
	public Profile(long id, String firstname, String lastname,
			String profilename, Date created) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilename = profilename;
		this.created = created;
	}
	
	public Profile(long id, String firstname, String lastname,
			String profilename) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilename = profilename;
		this.created = new Date();
	}
	
	public Profile(String firstname, String lastname,
			String profilename) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilename = profilename;
		this.created = new Date();
	}
	
	public Profile(String firstname, String lastname,
			String profilename,Date created) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilename = profilename;
		this.created = created;
	}
	
	public Profile() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getProfilename() {
		return profilename;
	}

	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
	
}

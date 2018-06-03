package org.arimac.jax.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.arimac.jax.messenger.model.Messagemodel;
import org.arimac.jax.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Messagemodel> message = new HashMap<>();
	private static Map<String,Profile> profile = new HashMap<>();
	
	public static Map<Long,Messagemodel> getMessages(){
		return message;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profile;
	}
	
	
}

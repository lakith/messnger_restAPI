package org.arimac.jax.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arimac.jax.messenger.database.DatabaseClass;
import org.arimac.jax.messenger.model.Profile;

public class profileService {

	private static Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public profileService(){
		Profile m1 = new Profile(1L,"Lakith","Muthugala","lakithmuthugala");
		Profile m2 = new Profile(2L,"Himasu","Chamath","himasuchamath");
		profiles.put(m1.getProfilename(), m1);
		profiles.put(m2.getProfilename(), m2);
	}
	
	public Profile getProfile(String proName)
	{
		return profiles.get(proName);
	}
	public Profile addProfile(Profile pro){
		pro.setId(profiles.size()+1);
		profiles.put(pro.getProfilename(), pro);
		return pro;
	}
	public Profile updateProfile(Profile pro){
		
		if(pro.getProfilename().isEmpty()){
			return null;
		} else{
			profiles.put(pro.getProfilename(), pro);
			return pro;
		}
		
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile removeProfile(String proName) {
		
		return profiles.remove(proName);
	}
	
}

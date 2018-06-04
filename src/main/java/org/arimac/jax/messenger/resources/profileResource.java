package org.arimac.jax.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arimac.jax.messenger.model.Messagemodel;
import org.arimac.jax.messenger.model.Profile;
import org.arimac.jax.messenger.service.profileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class profileResource {
	
	profileService pro = new profileService();

	@GET
	public List<Profile> getAllProfiles(){
		return pro.getAllProfiles();
	}
	
	@GET
	@Path("/{proName}")
	public Profile getProfile(@PathParam("proName") String proName)
	{
		return pro.getProfile(proName);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return pro.addProfile(profile);
	}
	
	@PUT
	@Path("/{proName}")
    public Profile updateMessage(Profile profile,@PathParam("proName")String proName){
    	profile.setProfilename(proName);
    	return pro.updateProfile(profile);
    	
    }
	
	@DELETE
	@Path("/{proName}")
	public Profile DeleteMEssage(@PathParam("proName") String proName)
	{
		return pro.removeProfile(proName);
	}
	
	
}

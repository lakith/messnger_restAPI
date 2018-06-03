package org.arimac.jax.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/testing")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ChekingParameters {
	
	@GET
	@Path("annotations")
	public String getParametersUsingAnnotations(@MatrixParam("param")String metrixParam,
			                                    @HeaderParam("headerparam")String header){
		
		Cookie ck=new Cookie("user","sonoo jaiswal");
		
		return "metrixParam "+ metrixParam+"header param " +header;
	}
	
	@GET
	public String display(){
		return "this is a test";
	}
	
	@GET
	@Path("/context")
	public String getContextPath(@Context UriInfo uriinfo){
		String path = uriinfo.getAbsolutePath().toString();
		return "path : "+path;
	}
	
}

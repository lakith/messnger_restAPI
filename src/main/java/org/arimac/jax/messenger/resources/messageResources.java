package org.arimac.jax.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.arimac.jax.messenger.model.Messagemodel;
import org.arimac.jax.messenger.model.Profile;
import org.arimac.jax.messenger.service.MessagesService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class messageResources {

	MessagesService ms = new MessagesService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messagemodel> getJSONMessages(@BeanParam MessengerfilterBean messngerbean){
		
		if(messngerbean.getYear() > 0 )
		{
			return ms.getAllmessagesForYear(messngerbean.getYear());
		}
		if(messngerbean.getStart() > 0 && messngerbean.getSize() > 0){
			return ms.getAllMessagespaginated(messngerbean.getStart(), messngerbean.getYear());
		}
		
		
		return ms.getAllMessage();
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Messagemodel> getXMLMessages(@BeanParam MessengerfilterBean messngerbean){
		
		if(messngerbean.getYear() > 0 )
		{
			return ms.getAllmessagesForYear(messngerbean.getYear());
		}
		if(messngerbean.getStart() > 0 && messngerbean.getSize() > 0){
			return ms.getAllMessagespaginated(messngerbean.getStart(), messngerbean.getYear());
		}
		
		
		return ms.getAllMessage();
	}
	
	@GET
	@Path("/{messageId}")
	public Messagemodel test(@PathParam("messageId") long m_id,@Context UriInfo uriInfo)
	{
		Messagemodel message1 = ms.getMessage(m_id);
		message1.addLink(getUriInfoSelf(uriInfo, message1), "self");
		message1.addLink(getUriInfoProfile(uriInfo, message1), "profile");
		message1.addLink(getUriInfoComment(uriInfo, message1), "comment");
		return message1;
	}

	private String getUriInfoComment(UriInfo uriInfo, Messagemodel message1) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(messageResources.class)
	            .path(Long.toString(message1.getId()))
	            .path("comments")
	            .build()
	            .toString();
        return uri;
	}

	private String getUriInfoProfile(UriInfo uriInfo, Messagemodel message1) {
		String uri = uriInfo.getBaseUriBuilder()
	            .path(profileResource.class)
	            .path(message1.getAuthor())
	            .build()
	            .toString();
        return uri;
	}

	private String getUriInfoSelf(UriInfo uriInfo, Messagemodel message1) {
		String uri = uriInfo.getBaseUriBuilder()
				            .path(messageResources.class)
				            .path(Long.toString(message1.getId()))
				            .build()
				            .toString();
		return uri;
	}
	
	@POST
	public Response testPost(Messagemodel message,@Context UriInfo uriInfo){
		
		Messagemodel m1 = ms.addMessage(message);
		String mId = String.valueOf(message.getId());
		URI uri =  uriInfo.getAbsolutePathBuilder().path(mId).build();
		return Response.created(uri).entity(m1).build();
	}
	
    @PUT
    @Path("/{messageId}")
    public Messagemodel updateMessage(Messagemodel message,@PathParam("messageId")long msg_id){
    	message.setId(msg_id);
    	return ms.updateMessage(message);
    	
    }
    
	@DELETE
	@Path("/{messageId}")
	public Messagemodel DeleteMEssage(@PathParam("messageId") long m_id)
	{
		return ms.removeMessage(m_id);
	}

	@Path("/{messageId}/comments")
	public CommentsResources getCommentResource(){
		return new CommentsResources();
	}
	
}

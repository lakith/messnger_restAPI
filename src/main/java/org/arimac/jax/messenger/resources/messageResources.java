package org.arimac.jax.messenger.resources;

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

import org.arimac.jax.messenger.model.Messagemodel;
import org.arimac.jax.messenger.service.MessagesService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class messageResources {

	MessagesService ms = new MessagesService();
	
	@GET
	public List<Messagemodel> getMessages(@BeanParam MessengerfilterBean messngerbean){
		
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
	public Messagemodel test(@PathParam("messageId") long m_id)
	{
		return ms.getMessage(m_id);
	}
	
	@POST
	public Messagemodel testPost(Messagemodel message){
		return ms.addMessage(message);
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

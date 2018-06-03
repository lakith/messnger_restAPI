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

import org.arimac.jax.messenger.model.Comment;
import org.arimac.jax.messenger.service.CommentsService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentsResources {

	CommentsService cs = new CommentsService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return cs.getAllComments(messageId);
	}
	
	@POST
	public Comment addPost(@PathParam("messageId") long messageId, Comment comment){
		return cs.addComment(messageId, comment);
	}
	
	@PUT
	public Comment updatePost(@PathParam("messageId") long messageId, Comment comment){
		return cs.updateComment(messageId, comment);
	}
	
	@DELETE
	public Comment deleteComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		return cs.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getOneComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		return cs.getComment(messageId, commentId);
	}
	

}

package org.arimac.jax.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.arimac.jax.messenger.database.DatabaseClass;
import org.arimac.jax.messenger.model.Comment;
import org.arimac.jax.messenger.model.ErrorMessage;
import org.arimac.jax.messenger.model.Messagemodel;

public class CommentsService {

	private static Map<Long,Messagemodel> messages = DatabaseClass.getMessages();
	Messagemodel m3 = new Messagemodel(3L,"This is sample 3","sachin");
	Messagemodel m4 = new Messagemodel(4L,"This is sample 4","chalana");
	Comment c1 = new Comment(1L,"sample comment","sachin");
	Comment c2 = new Comment(1L,"sample comment","chalana");
	
	public CommentsService() {
		messages.put(3L, m3);
		messages.put(4L, m4);
	}
	
	public List<Comment> getAllComments(long messageId){

		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.put(m3.getId(), c1);
		comments.put(m4.getId(), c2);
		
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageID, long commentId){
		
		Messagemodel message = messages.get(messageID);
		
		ErrorMessage error = new ErrorMessage("NOT FOUND",404,"https://www.google.com");
		
		Response r1= Response.status(Status.NOT_FOUND)
					   .entity(error)
					   .type(MediaType.APPLICATION_JSON)
					   .build();
		
		if(message == null)
		{
            throw new WebApplicationException(r1);			
		}
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		comments.put(m3.getId(), c1);
		comments.put(m4.getId(), c2);
		Comment c1 = comments.get(commentId);
		if(c1==null){
			throw new NotFoundException(r1);
		}
		return c1;
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.put(m3.getId(), c1);
		comments.put(m4.getId(), c2);
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long message_id, Comment comment){
		Map<Long,Comment> comments = messages.get(message_id).getComments();
		comments.put(m3.getId(), c1);
		comments.put(m4.getId(), c2);
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment removeComment (long messageId, long commentId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.put(m3.getId(), c1);
		comments.put(m4.getId(), c2);
		return comments.remove(commentId);
		
	}
	
	
}

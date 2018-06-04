package org.arimac.jax.messenger.exeption;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.arimac.jax.messenger.model.ErrorMessage;

@Provider
public class GenaricExeptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(),500,"https://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
		.type(MediaType.APPLICATION_JSON)
		.entity(error)
		.build();
	
	}

}

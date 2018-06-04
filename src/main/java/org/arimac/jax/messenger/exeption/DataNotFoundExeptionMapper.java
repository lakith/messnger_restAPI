package org.arimac.jax.messenger.exeption;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.arimac.jax.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExeptionMapper implements ExceptionMapper<DataNotFoundExeption>{

	@Override
	public Response toResponse(DataNotFoundExeption exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(),404,"https://www.google.com");
		return Response.status(Status.NOT_FOUND)
					   .entity(error)
					   .type(MediaType.APPLICATION_JSON)
					   .build();
	}



}

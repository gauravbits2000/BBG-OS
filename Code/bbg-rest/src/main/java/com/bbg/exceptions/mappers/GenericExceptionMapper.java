package com.bbg.exceptions.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bbg.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage message = new ErrorMessage(exception.getMessage() , 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).type(MediaType.APPLICATION_JSON).build();
	}

}

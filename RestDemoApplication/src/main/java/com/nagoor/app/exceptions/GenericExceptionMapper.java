package com.nagoor.app.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.nagoor.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

  @Override
  public Response toResponse(Throwable exception) {
	  ErrorMessage emsg=new ErrorMessage(404,exception.getMessage(),"Helo nagoor");
    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(emsg)
    		.build();
  }
	
}

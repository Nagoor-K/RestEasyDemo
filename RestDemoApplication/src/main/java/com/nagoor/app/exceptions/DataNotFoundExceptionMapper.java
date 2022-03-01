package com.nagoor.app.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.nagoor.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundEception>{

  @Override
  public Response toResponse(DataNotFoundEception exception) {
	  ErrorMessage emsg=new ErrorMessage(404,exception.getMessage(),"Helo nagoor");
    return Response.status(Status.NOT_FOUND).entity(emsg).build();
  	}
  }

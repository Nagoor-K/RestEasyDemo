package com.nagoor.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageRestService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg() {
		return "Hello Nagoor Khan";
	}

}
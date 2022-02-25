package com.nagoor.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comment")
public class CommentService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCmt() {
		return "This is comment";
	}
	@GET
	@Path("/{getc}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAc(@PathParam("getc") String str) {
		return "you gave : "+str;
	}
}

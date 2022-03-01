package com.nagoor.restful;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class CommentResources {
	
	@GET
	@Path("/{cmtId}")
	@Produces(MediaType.APPLICATION_XML)
	public String test(@PathParam("cmtId") long cid) {
		return "Hello Nagoor Khan"+cid;
	}
}

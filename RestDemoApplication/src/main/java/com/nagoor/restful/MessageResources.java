package com.nagoor.restful;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.nagoor.model.ErrorMessage;
import com.nagoor.model.Messages;
import com.nagoor.service.MessageService;

@Path("/messages")
public class MessageResources {
	MessageService ms=new MessageService();
	
	@DELETE
	@Path("delete/{Msg}")
	@Produces(MediaType.APPLICATION_XML)
	public void delMsg(@PathParam("Msg") long id) {
		ms.removeMessage(id);
	}
	
	@PUT
	@Path("/{Msg}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Messages updateMag(@PathParam("Msg") String val, Messages msg) {
		msg.setMsg(val);
		return ms.updateMessage(msg);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMsg(Messages msg, @Context UriInfo urinfo) {
		Messages newMsg=ms.addMessage(msg);
		String newId=String.valueOf(newMsg.getId());
		URI uri=urinfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMsg)
				.build();
	}
	

	
	@GET
	@Path("/getall")
	@Produces(value = {MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public List<Messages> getAllMsgs(@QueryParam("date") String date,@QueryParam("size") int size){
		if(size>0) {
			return ms.getListBySize(size);
		}
		if(date!=null) {
			return ms.getListByDate(date);
		}
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public Messages getMsg(@PathParam("msgId") long id) {
		ErrorMessage e=new ErrorMessage("Not Found", 404, "https:resrDemoApplicationNotFound");
		Response response=Response.status(Status.NOT_FOUND)
				.entity(e)
				.build();
		Messages m=ms.getMessage(id);
		if(m==null) {
			throw new WebApplicationException(response);
		}
		return m;
	}
	
	@Path("/{msgId}/comments")
	public CommentResources getCommentResources(){
		return new CommentResources();
	}

}
package com.nagoor.restful;

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
import javax.ws.rs.core.MediaType;

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
	public Messages addMsg(Messages msg) {
		return ms.addMessage(msg);
	}
	

	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_XML)
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
		return ms.getMessage(id);
	}
	
	@Path("/{msgId}/comments")
	public CommentResources getCommentResources(){
		return new CommentResources();
	}

}
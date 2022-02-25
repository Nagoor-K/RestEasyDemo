package com.nagoor.restful;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagoor.model.Messages;
import com.nagoor.service.MessageService;

@Path("/messages")
public class MessageResources {
	MessageService ms=new MessageService();
	
	
	@GET
	@Path("/delete/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public String delMsg(@PathParam("/delete/msgId") long id) {
    return ms.deleteMessage(id);
		
	}
	
	@GET
	@Path("/addmsg")
	@Produces(MediaType.APPLICATION_XML)
	public String addMsg() {
		String msg="Hi Nagoor Khan";
		return ms.addMessage(msg);
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_XML)
	public List<Messages> getAllMsgs(){
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public Messages getMsg(@PathParam("msgId") long id) {
		return ms.getMessage(id);
	}

}
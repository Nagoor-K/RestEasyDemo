package com.nagoor.restful;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagoor.model.Messages;
import com.nagoor.service.MessageService;

@Path("/message")
public class MessageRestService {
	MessageService ms=new MessageService();
	@GET
	@Path("/one")
	@Produces(MediaType.TEXT_PLAIN)
	public Messages getMsg() {
		return ms.getMessage();
	}
	@GET
	@Path("/getall")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Messages> getAllmessages(){
		return ms.getAllMessages();
	}

}
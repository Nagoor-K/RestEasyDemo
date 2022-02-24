package com.nagoor.app;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.nagoor.restful.CommentService;
import com.nagoor.restful.MessageRestService;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageRestService());
		singletons.add(new CommentService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

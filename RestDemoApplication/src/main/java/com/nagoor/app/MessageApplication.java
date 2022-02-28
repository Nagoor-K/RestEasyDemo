package com.nagoor.app;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import com.nagoor.restful.CommentResources;
import com.nagoor.restful.MessageResources;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageResources());
		singletons.add(new CommentResources());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

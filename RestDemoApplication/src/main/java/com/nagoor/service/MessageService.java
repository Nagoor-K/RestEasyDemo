package com.nagoor.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.nagoor.model.Messages;
import com.nagoor.model.module.PersistenceModele;

public class MessageService {
	@Inject
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public MessageService() {
		Injector injector = Guice.createInjector(new PersistenceModele());
		emf = injector.getInstance(EntityManagerFactory.class);
	}
	
	public Messages addMessage(Messages msg) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(msg);
		em.getTransaction().commit();
		return msg;
	}
	
	public String deleteMessage(long id) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Messages m=(Messages)em.find(Messages.class, id);
		PrintWriter out=new PrintWriter(System.out);
		out.print(m);
		//em.remove(m);
		em.getTransaction().commit();
		return "Message deleted successfully";
	}
	
	public Messages getMessage(long id) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Messages m=new Messages();
		m=em.find(Messages.class, id);
		em.getTransaction().commit();
    return m;
		
	}
	
	
	
	public List<Messages> getAllMessages(){
		em=emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Messages> l=new ArrayList<>();
		for(long i=0;i<5;i++) {
			l.add(em.find(Messages.class, i));
		}
		em.getTransaction().commit();
		return l;
	}
}

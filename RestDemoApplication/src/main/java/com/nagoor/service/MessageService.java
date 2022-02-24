package com.nagoor.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nagoor.model.Messages;

public class MessageService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Eclipselink_JPA");
	EntityManager em;
	Messages m=new Messages();  
	public Messages getMessage() {
		m.setId(1);
		m.setMsg("Hello Nagoor Khan");
		m.setDate("24");
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
    return m;
		
	}
	public List<Messages> getAllMessages(){
		em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Messages> al = new ArrayList<Messages>();
		al.add(em.find(Messages.class, 1));
		al.add(em.find(Messages.class, 2));

		al.add(em.find(Messages.class, 3));

		return al;
	}
}

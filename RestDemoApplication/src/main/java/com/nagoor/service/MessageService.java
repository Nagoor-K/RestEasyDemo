package com.nagoor.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
	
	public void removeMessage(long id) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Messages m=new Messages();
		m=em.find(Messages.class, id);
		System.out.println(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public Messages updateMessage(Messages msg) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(msg);
		em.getTransaction().commit();
		em.close();
		return msg;
	}
	
	public Messages addMessage(Messages msg) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(msg);
		em.getTransaction().commit();
		em.close();
		return msg;
	}
	
	public Messages getMessage(long id) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Messages m=new Messages();
		m=em.find(Messages.class, id);
		System.out.println(m);

		em.getTransaction().commit();
		em.close();
    return m;
		
	}
	
	public List<Messages> getListBySize(int size){
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Query q=em.createQuery("FROM Messages");
		q.setMaxResults(size);
		return q.getResultList();
	}
	
	public List<Messages> getListByDate(String date){
		em=emf.createEntityManager();
		em.getTransaction().begin();
		return em.createQuery("FROM Messages m WHERE m.date='28'", Messages.class).getResultList();
	}
	
	public List<Messages> getAllMessages(){
		em=emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Messages> l=new ArrayList<>();
		Query query=em.createQuery("SELECT count(*) FROM Messages");
		long count=(long) query.getSingleResult();
		for(long i=0;i<count;i++) {
			l.add(em.find(Messages.class, i));
		}
		em.getTransaction().commit();
		em.close();
		return l;
	}
}

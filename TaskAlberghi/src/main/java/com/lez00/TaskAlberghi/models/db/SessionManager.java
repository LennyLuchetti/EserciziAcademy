package com.lez00.TaskAlberghi.models.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lez00.TaskAlberghi.models.Albergo;
import com.lez00.TaskAlberghi.models.Stanza;

public class SessionManager {
	
	private static SessionManager sm;
	private SessionFactory factory;
	
	public static SessionManager getIstanza() {
		if(sm==null)
			sm = new SessionManager();
		
		return sm;
	}
	
	private SessionManager() {
		
	}
	
	public SessionFactory getFactory() {
		
		if(factory==null)
			factory = new Configuration()
			.configure("/resources/hibernate.cfg.xml")
			.addAnnotatedClass(Albergo.class)
			.addAnnotatedClass(Stanza.class)
			.buildSessionFactory();
		
		return factory;
		
	}

}

package com.lez00.TaskHibernateLibri.models.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lez00.TaskHibernateLibri.models.Libro;

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
			.addAnnotatedClass(Libro.class)
			.buildSessionFactory();
		
		return factory;
		
	}

}

package com.lez00.TaskHibernateLibri.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.lez00.TaskHibernateLibri.models.Libro;
import com.lez00.TaskHibernateLibri.models.db.SessionManager;

public class LibroDao implements IDao<Libro> {

	private static LibroDao ogg;

	public static LibroDao getIstanza() {
		if (ogg == null)
			ogg = new LibroDao();

		return ogg;
	}

	private LibroDao() {

	}

	@Override
	public boolean insert(Libro t) {
		Session sessione = SessionManager.getIstanza().getFactory().getCurrentSession();

		try {
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e) {
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sessione.close();
		}

		return !(t.getId() == null);
	}

	@Override
	public List<Libro> findAll() {
		Session sessione = SessionManager.getIstanza().getFactory().getCurrentSession();
		List<Libro> elenco = new ArrayList<Libro>();
		
		try {
    		sessione.beginTransaction();
    		elenco = sessione.createQuery("FROM Persona").list();
    		sessione.getTransaction().commit();	
    	} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sessione.close();
		}
		return elenco;
	}

	@Override
	public Libro findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Libro t) {
		// TODO Auto-generated method stub
		return false;
	}

}

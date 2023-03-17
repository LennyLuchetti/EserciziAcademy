package com.lez00.TaskAlberghi.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.lez00.TaskAlberghi.models.Albergo;
import com.lez00.TaskAlberghi.models.Stanza;
import com.lez00.TaskAlberghi.models.db.SessionManager;

public class StanzaDao implements IDao<Stanza>{
	
    private static StanzaDao ogg;
	
	public static StanzaDao getIstanza() {
		if(ogg==null)
			ogg = new StanzaDao();
		
		return ogg;
	}
	
	private StanzaDao() {
		
	}

	@Override
	public boolean insert(Stanza t) {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		try {
		sess.beginTransaction();
		sess.save(t);
		sess.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sess.close();
		}
		return !(t.getStanzaID() == null);
	}

	@Override
	public List<Stanza> findAll() {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		List<Stanza> elenco = new ArrayList<Stanza>();
		try {
		sess.beginTransaction();
		elenco = sess.createQuery("FROM Stanza").list();
		sess.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sess.close();
		}
		return elenco;
	}

	@Override
	public Stanza findById(Integer id) {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		Stanza temp = new Stanza();
		
		try {
			sess.beginTransaction();
    		temp = sess.get(Stanza.class, id);
    		sess.getTransaction().commit();	
    	} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sess.close();
		}
		return temp;
	}

	@Override
	public boolean delete(Integer id) {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		boolean risultato = false;
		try {
			sess.beginTransaction();
			Stanza temp = sess.get(Stanza.class, id);
    		sess.delete(temp);
    		sess.getTransaction().commit();	
    		risultato = true;
    	} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sess.close();
		}
		return risultato;
	}

	@Override
	public boolean update(Stanza t) {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		boolean risultato = false;
		try {
			sess.beginTransaction();
			sess.update(t);
			sess.getTransaction().commit();	
    		risultato = true;
    	} catch (IllegalStateException e) {
			System.out.println("Sono in illegal");
		} catch (RollbackException e) {
			System.out.println("Sono in rollback");
		} catch (Exception e){
			System.out.println("Sono in generica Ex: " + e.getMessage());
		} finally {
			sess.close();
		}
		return risultato;
	}

}

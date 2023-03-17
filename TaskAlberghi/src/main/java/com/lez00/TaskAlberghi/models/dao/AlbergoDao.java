package com.lez00.TaskAlberghi.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import com.lez00.TaskAlberghi.models.Albergo;
import com.lez00.TaskAlberghi.models.db.SessionManager;

public class AlbergoDao implements IDao<Albergo>{
	
    private static AlbergoDao ogg;
	
	public static AlbergoDao getIstanza() {
		if(ogg==null)
			ogg = new AlbergoDao();
		
		return ogg;
	}
	
	private AlbergoDao() {
		
	}

	@Override
	public boolean insert(Albergo t) {
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
		return !(t.getAlbergoID() == null);
	}

	@Override
	public List<Albergo> findAll() {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		List<Albergo> elenco = new ArrayList<Albergo>();
		try {
		sess.beginTransaction();
		elenco = sess.createQuery("FROM Albergo").list();
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
	public Albergo findById(Integer id) {
		Session sess = SessionManager.getIstanza().getFactory().getCurrentSession();
		Albergo temp = new Albergo();
		
		try {
			sess.beginTransaction();
    		temp = sess.get(Albergo.class, id);
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
			Albergo temp = sess.get(Albergo.class, id);
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
	public boolean update(Albergo t) {
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

package com.lez00.TaskAlberghi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.lez00.TaskAlberghi.models.Albergo;
import com.lez00.TaskAlberghi.models.Stanza;
import com.lez00.TaskAlberghi.models.dao.AlbergoDao;
import com.lez00.TaskAlberghi.models.dao.StanzaDao;
import com.lez00.TaskAlberghi.models.db.SessionManager;

public class App 
{
    public static void main( String[] args )
    {
        
    	try {
    		Session sessione = SessionManager.getIstanza().getFactory().getCurrentSession();
    		
    		sessione.beginTransaction();
    		Albergo alb1 = new Albergo("Hotel Colombo", "Roma", 4);
    		Albergo alb2 = new Albergo("Hotel Peppino", "Milano", 3);
    		Albergo alb3 = new Albergo("Hotel Cancro", "Fiuggi", 5);
    		
    		Stanza sta1 = new Stanza("Suite", false, alb3);
    		Stanza sta2 = new Stanza("Matrimoniale", false, alb1);
    		Stanza sta3 = new Stanza("Matrimoniale", false, alb2);
    		Stanza sta4 = new Stanza("Matrimoniale", false, alb3);
    		Stanza sta5 = new Stanza("Singola", false, alb1);
    		Stanza sta6 = new Stanza("Singola", false, alb2);
    		
    		AlbergoDao.getIstanza().insert(alb1);
    		AlbergoDao.getIstanza().insert(alb2);
    		AlbergoDao.getIstanza().insert(alb3);
    		
    		StanzaDao.getIstanza().insert(sta1);
    		StanzaDao.getIstanza().insert(sta2);
    		StanzaDao.getIstanza().insert(sta3);
    		StanzaDao.getIstanza().insert(sta4);
    		StanzaDao.getIstanza().insert(sta5);
    		StanzaDao.getIstanza().insert(sta6);
    		
    		AlbergoDao.getIstanza().findAll();
    		
    		sessione.getTransaction().commit();
    		
    	} catch (Exception e){
    		System.out.println(e.getMessage());
    	} 
    }
}

package com.lez00.TaskHibernateLibri.models;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.Session;

import com.lez00.TaskHibernateLibri.models.db.SessionManager;

public class CSVtoMySQL {

	Session sessione = SessionManager.getIstanza().getFactory().getCurrentSession();

	try{
		sessione.beginTransaction();

		BufferedReader reader = new BufferedReader(new FileReader("libri.csv"));
		String line;
		while ((line = reader.readLine()) != null) {
			String[] row = line.split(",");
			Libro entity = new Libro();
			entity.setTitolo(row[0]);
			entity.setDescrizione(row[1]);
			entity.setAutore(row[2]);
			entity.setDataPubb(row[3]);
			entity.setIsbn(row[4]);
			entity.setPrezzo(Float.parseFloat(row[5]));
			entity.setEditore(row[6]);

			sessione.save(entity);
		}

		sessione.getTransaction().commit();
	} catch(Exception e) {
		System.out.println("Errore" + e.getMessage());
	} finally {
		sessione.close();
	}

}

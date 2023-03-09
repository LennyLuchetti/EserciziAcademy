package es01.gestione_libri;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es01.gestione_libri.models.Libro;
import es01.gestione_libri.models.Dao.LibroDao;

public class GestoreLibro {
	
	private static GestoreLibro ogg;
	
	public static GestoreLibro getIstanza() {
		if (ogg == null)
			ogg = new GestoreLibro();

		return ogg;
	}

	private GestoreLibro() {

	}
	
	public boolean inserisciLibro(String titolo, String descrizione, String data_pubbl, String codice, Float prezzo, String autore) {
		Libro temp = new Libro(titolo, descrizione, data_pubbl, codice, prezzo, autore);
		
		try {
			return LibroDao.getIstanza().insert(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Libro> stampaLibri() {
		
		List<Libro> elenco = new ArrayList<Libro>();
		
		try {
			elenco = LibroDao.getIstanza().findAll();
//			List<Libro> elenco = LibroDao.getIstanza().findAll();
//			for(Libro l: elenco) {
//				System.out.println(l);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elenco;
	}

}

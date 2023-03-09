package es01.gestione_libri;

import es01.gestione_libri.models.Libro;

public class Main {

	public static void main(String[] args) {
		
//		Libro lib1 = new Libro("Mein Kampf", "Autobiografia di Hitler", "1925-06-23", "MKF123", 10.5f, "Adolf Hitler");
//		Libro lib2 = new Libro("Harry Potter", "Fantasy con i maghi", "1996-09-29", "HPT123", 14.5f, "J. K. Rowling");
//		Libro lib3 = new Libro("Il Signore degli Anelli", "Fantasy con gli anelli", "1954-12-12", "SDA123", 20f, "J. R. R. Tolkien");
//		
//		try {
//			LibroDao.getIstanza().insert(lib1);
//			LibroDao.getIstanza().insert(lib2);
//			LibroDao.getIstanza().insert(lib3);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if(GestoreLibro.getIstanza().inserisciLibro("Caccamo", "Bucchin", "2010-11-02", "CAB123", 5.5f, "Ziopera"))
			System.out.println("Tutto ok");
		else
			System.out.println("Errore");
		
		for(Libro l: GestoreLibro.getIstanza().stampaLibri()) {
			System.out.println(l);
		}
		
	}

}

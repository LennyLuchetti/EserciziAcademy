package es01.gestione_libri.models.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es01.gestione_libri.models.Libro;
import es01.gestione_libri.models.db.ConnettoreDB;

public class LibroDao implements Dao<Libro> {

	private static LibroDao libDao;

	public static LibroDao getIstanza() {
		if (libDao == null)
			libDao = new LibroDao();

		return libDao;
	}

	private LibroDao() {

	}

	@Override
	public boolean insert(Libro t) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();

		String query = "INSERT INTO Libro(titolo, descrizione, data_pubbl, codice, prezzo, autore) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, t.getTitolo());
		ps.setString(2, t.getDescrizione());
		ps.setString(3, t.getData_pubbl());
		ps.setString(4, t.getCodice());
		ps.setFloat(5, t.getPrezzo());
		ps.setString(6, t.getAutore());

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		rs.next();

		Integer idGenerato = rs.getInt(1);
		t.setLibroID(idGenerato);

		if (idGenerato > 0)
			return true;

		return false;
	}

	@Override
	public List<Libro> findAll() throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		List<Libro> elenco = new ArrayList<>();

		String query = "SELECT libroID, titolo, descrizione, data_pubbl, codice, prezzo, autore FROM Libro";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Libro temp = new Libro();
			temp.setLibroID(rs.getInt(1));
			temp.setTitolo(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setData_pubbl(rs.getString(4));
			temp.setCodice(rs.getString(5));
			temp.setPrezzo(rs.getFloat(6));
			temp.setAutore(rs.getString(7));

			elenco.add(temp);
		}
		return elenco;
	}

	@Override
	public Libro findById(Integer id) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		Libro risultato = null;
		
		String query = "SELECT libroID, titolo, descrizione, data_pubbl, codice, prezzo, autore FROM Libro WHERE libroID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Libro temp = new Libro();
			temp.setLibroID(rs.getInt(1));
			temp.setTitolo(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setData_pubbl(rs.getString(4));
			temp.setCodice(rs.getString(5));
			temp.setPrezzo(rs.getFloat(6));
			temp.setAutore(rs.getString(7));
			
			risultato = temp;
		}
		return risultato;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		
		String query = "DELETE FROM Libro WHERE libroID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		int affRows = ps.executeUpdate();
		if(affRows > 0)
			return true;
		
		return false;
	}
	
	public Libro findByISBN(String codice) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		Libro risultato = null;
		
		String query = "SELECT libroID, titolo, descrizione, data_pubbl, codice, prezzo, autore FROM Libro WHERE codice = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, codice);
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Libro temp = new Libro();
			temp.setLibroID(rs.getInt(1));
			temp.setTitolo(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setData_pubbl(rs.getString(4));
			temp.setCodice(rs.getString(5));
			temp.setPrezzo(rs.getFloat(6));
			temp.setAutore(rs.getString(7));
			
			risultato = temp;
		}
		return risultato;
	}

}

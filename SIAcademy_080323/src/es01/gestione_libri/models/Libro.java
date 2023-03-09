package es01.gestione_libri.models;

import java.util.Scanner;

public class Libro {
	
	private Integer libroID;
	private String titolo;
	private String descrizione;
	private String data_pubbl;
	private String codice;
	private Float prezzo;
	private String autore;
	
	public Libro() {
		
	}

	public Libro(String titolo, String descrizione, String data_pubbl, String codice, Float prezzo,  String autore) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.data_pubbl = data_pubbl;
		this.codice = codice;
		this.prezzo = prezzo;
		this.autore = autore;
	}

	public Integer getLibroID() {
		return libroID;
	}

	public void setLibroID(Integer libroID) {
		this.libroID = libroID;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getData_pubbl() {
		return data_pubbl;
	}

	public void setData_pubbl(String data_pubbl) {
		this.data_pubbl = data_pubbl;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libro [libroID=" + libroID + ", titolo=" + titolo + ", descrizione=" + descrizione + ", data_pubbl="
				+ data_pubbl + ", codice=" + codice + ", prezzo=" + prezzo + ", autore=" + autore + "]";
	}
	
//	public Libro inserisciLibro(Libro temp) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Inserisci il titolo.");
//		temp.setTitolo(in.nextLine());
//		System.out.println("Inserisci la descrizione.");
//		temp.setDescrizione(in.nextLine());
//		System.out.println("Inserisci la data di pubblicazione in formato yyyy-mm-dd.");
//		temp.setData_pubbl(in.nextLine());
//		System.out.println("Inserisci il codice univoco.");
//		temp.setCodice(in.nextLine());
//		System.out.println("Inserisci il prezzo.");
//		temp.setPrezzo(Float.valueOf(in.nextLine()));
//		System.out.println("Inserisci l'autore.");
//		temp.setAutore(in.nextLine());
//		return temp;
//	}

}

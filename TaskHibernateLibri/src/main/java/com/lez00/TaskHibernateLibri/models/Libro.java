package com.lez00.TaskHibernateLibri.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Libri")
public class Libro {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "libroID")
		private Integer id;
		@Column
		private String titolo;
		@Column
		private String descrizione;
		@Column
		private String autore;
		@Column(name = "data_pubb")
		private String dataPubb ;
		@Column
		private String isbn;
		@Column
		private Float prezzo;
		@Column(name="casa_editrice")
		private String editore;
		
		public Libro() {
			
		}

		public Libro(String titolo, String descrizione, String autore, String dataPubb, String isbn, Float prezzo,
				String editore) {
			super();
			this.titolo = titolo;
			this.descrizione = descrizione;
			this.autore = autore;
			this.dataPubb = dataPubb;
			this.isbn = isbn;
			this.prezzo = prezzo;
			this.editore = editore;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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

		public String getAutore() {
			return autore;
		}

		public void setAutore(String autore) {
			this.autore = autore;
		}

		public String getDataPubb() {
			return dataPubb;
		}

		public void setDataPubb(String dataPubb) {
			this.dataPubb = dataPubb;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public Float getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(Float prezzo) {
			this.prezzo = prezzo;
		}

		public String getEditore() {
			return editore;
		}

		public void setEditore(String editore) {
			this.editore = editore;
		}
		
}

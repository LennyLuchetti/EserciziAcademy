package com.lez00.TaskAlberghi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prenotazioneID")
	private Integer id;
	@Column
	private String codice;
	@Column
	private String nominativo;
	@Column(name="data_inizio")
	private Date inizio;
	@Column(name="data_fine")
	private Date fine;
	@Column(name="data_prenotazione")
	private Date pren;
	
	@ManyToOne
	@JoinColumn(name="stanzaRIF")
	private Stanza stanzaPrenotata;

}

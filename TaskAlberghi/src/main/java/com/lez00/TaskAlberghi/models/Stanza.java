package com.lez00.TaskAlberghi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Stanza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stanzaID")
	private Integer id;
	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private Boolean occupata;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="albergoRIF")
	private Albergo albergo;
	
	@OneToMany(mappedBy = "stanzaPrenotata")
	private List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();
	
	public Stanza() {
		
	}

}

package com.lez00.TaskAlberghi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Albergo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="albergoID")
	private Integer id;
	@Column
	private String nome;
	@Column
	private String indirizzo;
	@Column
	private Integer stelle;
	
	@OneToMany(mappedBy = "proprietario")
	private List<Stanza> listaStanze = new ArrayList<Stanza>();
	
	public Albergo() {
		
	}

}

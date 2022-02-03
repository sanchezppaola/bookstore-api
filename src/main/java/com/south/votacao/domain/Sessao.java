package com.south.votacao.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sessao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name= "pauta_id")
	private Pauta pauta;

	public Sessao() {
		super();
	}

	public Sessao(String id, String descricao, Pauta pauta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pauta = pauta;
	}
	public Sessao(String id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
}
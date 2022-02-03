package com.south.votacao.dtos;

import java.io.Serializable;

import com.south.votacao.domain.Pauta;

public class PautaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	public PautaDTO() {
		super();
	}
	public PautaDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public PautaDTO(Pauta pauta) {
		super();
		this.id = pauta.getId();
		this.descricao = pauta.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
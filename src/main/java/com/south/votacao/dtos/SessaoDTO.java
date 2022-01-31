package com.south.votacao.dtos;

import java.io.Serializable;

import com.south.votacao.domain.Sessao;

public class SessaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String descricao;
	
	public SessaoDTO() {
		super();
	}
	public SessaoDTO(String id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	public SessaoDTO(Sessao sessaoDTO) {
		super();
		this.id = sessaoDTO.getId();
		this.descricao = sessaoDTO.getDescricao();
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
}
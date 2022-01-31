package com.south.votacao.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.south.votacao.domain.Sessao;
import com.south.votacao.repositories.SessaoRepository;

@Service
public class SessaoService {
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private PautaService pautaService;
		
	public Sessao findById(Integer id) {
		Optional<Sessao> sessao = sessaoRepository.findById(id);
		return sessao.orElseThrow(() -> new ObjectNotFoundException(
				"Sessão nao encontrada! Id:" + id + ", Tipo: " + Sessao.class.getName(), null));
		
	}
	public List<Sessao> findAll(Integer id_pauta){
		pautaService.findById(id_pauta);
		return sessaoRepository.findAllByPauta(id_pauta);
	}
}

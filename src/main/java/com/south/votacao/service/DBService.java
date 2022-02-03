package com.south.votacao.service;


import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.south.votacao.domain.Pauta;
import com.south.votacao.domain.Sessao;
import com.south.votacao.repositories.PautaRepository;
import com.south.votacao.repositories.SessaoRepository;

@Service
public class DBService {
	
	@Autowired
	private PautaRepository pautaRepository;
	@Autowired
	private SessaoRepository sessaoRepository;
	

	public void instanciaBaseDeDados() {
		
		Pauta pauta1 = new Pauta(null, "pauta de votação nº 1");
		
		Sessao sessao1 = new Sessao(null, "sessão nº 12");
		
		
		pauta1.getSessao().addAll(Arrays.asList(sessao1));
		
		pautaRepository.saveAll(Arrays.asList(pauta1));
		sessaoRepository.saveAll(Arrays.asList(sessao1));
		
	}
	
	  
}

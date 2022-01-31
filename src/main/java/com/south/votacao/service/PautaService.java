package com.south.votacao.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.south.votacao.domain.Pauta;
import com.south.votacao.dtos.PautaDTO;
import com.south.votacao.repositories.PautaRepository;


@Service
public class PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	
	public Pauta findById(Integer id) {
		Optional<Pauta> pauta = pautaRepository.findById(id);
		return pauta.orElseThrow(() -> new ObjectNotFoundException("Pauta nao encontrada! id: " + id + ", Tipo: " + Pauta.class.getName(), null));
		
	}
	
	public List<Pauta> findAll(){
		return pautaRepository.findAll();
		 
	}
	
	public Pauta create(Pauta pauta) {
		pauta.setId(null);
		return pautaRepository.save(pauta);
	}

	public Pauta update(Integer id, PautaDTO pautaDTO) {
		Pauta pauta = findById(id);
		pauta.setDescricao(pautaDTO.getDescricao());
		return pautaRepository.save(pauta);
		
	}

	public void delete(Integer id) {
		findById(id);
		try {
			pautaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.south.votacao.service.exceptions.DataIntegrityViolationException(
					"Pauta nao pode ser deletada! Possui sessão associada");
		}
	}
}
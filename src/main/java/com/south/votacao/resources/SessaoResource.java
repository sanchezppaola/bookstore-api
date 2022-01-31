package com.south.votacao.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.south.votacao.domain.Sessao;
import com.south.votacao.dtos.SessaoDTO;
import com.south.votacao.service.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoResource {
	
	@Autowired
	private SessaoService sessaoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Sessao> findById(@PathVariable Integer id){
		Sessao sessao = sessaoService.findById(id);
		return ResponseEntity.ok().body(sessao);
		
	}
	
	@GetMapping
	public ResponseEntity<List<SessaoDTO>> findAll(@RequestParam(value = "pauta", defaultValue = "0") Integer id_pauta){
		List<Sessao> sessoes = sessaoService.findAll(id_pauta);
		List<SessaoDTO> sessoesDTO = sessoes.stream().map(sessao -> new SessaoDTO(sessao)).collect(Collectors.toList());
		return ResponseEntity.ok().body(sessoesDTO);
		
		
	}
}

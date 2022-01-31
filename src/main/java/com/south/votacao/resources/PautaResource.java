package com.south.votacao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.south.votacao.domain.Pauta;
import com.south.votacao.dtos.PautaDTO;
import com.south.votacao.service.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaResource {
	
	
	@Autowired
	private PautaService pautaService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Pauta> findById(@PathVariable Integer id){
		Pauta pauta = pautaService.findById(id);
		return ResponseEntity.ok().body(pauta);
	}
	
	@GetMapping
	public ResponseEntity<List<PautaDTO>> findAll(){
		List<Pauta> pauta = pautaService.findAll();
		List<PautaDTO> pautaDTO = pauta.stream().map(p -> new PautaDTO(p)).collect(Collectors.toList());
		return ResponseEntity.ok().body(pautaDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<Pauta> create(@RequestBody Pauta pauta){
		pauta = pautaService.create(pauta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pauta.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PautaDTO> update(@PathVariable Integer id, @RequestBody PautaDTO pautaDTO){
		Pauta newPauta = pautaService.update(id, pautaDTO);
		return ResponseEntity.ok().body(new PautaDTO(newPauta));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		pautaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}

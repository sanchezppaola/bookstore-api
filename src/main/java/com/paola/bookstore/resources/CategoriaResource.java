package com.paola.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paola.bookstore.domain.Categoria;
import com.paola.bookstore.dtos.CategoriaDTO;
import com.paola.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
		categoria = categoriaService.create(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	}
		
	
}

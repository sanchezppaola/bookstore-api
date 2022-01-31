package com.paola.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paola.bookstore.domain.Livro;
import com.paola.bookstore.dtos.LivroDTO;
import com.paola.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
		
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria){
		List<Livro> list = livroService.findAll(id_categoria);
		List<LivroDTO> listDTO = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
		
	}
}

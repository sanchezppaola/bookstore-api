package com.paola.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paola.bookstore.domain.Livro;
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
}

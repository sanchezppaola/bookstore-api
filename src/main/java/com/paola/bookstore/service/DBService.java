package com.paola.bookstore.service;


import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paola.bookstore.domain.Categoria;
import com.paola.bookstore.domain.Livro;
import com.paola.bookstore.repositories.CategoriaRepository;
import com.paola.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	

	public void instanciaBaseDeDados() {
		
		Categoria categoria1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria categoria2 = new Categoria(null, "Ficção científica", "Livros de Ficção científica");
		Categoria categoria3 = new Categoria(null, "Biografia", "Livros de Biografia");
		
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", categoria1);
		Livro livro2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Lorem ipsum", categoria1);
		Livro livro3 = new Livro(null, "The Time Machine", "H.G. Wells ", "Lorem ipsum", categoria2);
		Livro livro4 = new Livro(null, "The wars of the worlds", "H.G. Wells ", "Lorem ipsum", categoria2);
		
		categoria1.getLivros().addAll(Arrays.asList(livro1, livro2));
		categoria2.getLivros().addAll(Arrays.asList(livro3, livro4));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4));
		
	}
	
	  
}

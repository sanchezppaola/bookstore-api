package com.paola.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paola.bookstore.domain.Livro;
import com.paola.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
		
	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo: " + Livro.class.getName(), null));
		
	}
	public List<Livro> findAll(Integer id_categoria){
		categoriaService.findById(id_categoria);
		return livroRepository.findAllByCategoria(id_categoria);
	}
}

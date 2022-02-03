package com.paola.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paola.bookstore.domain.Categoria;
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
	
	public Livro update(Integer id, Livro livro) {
		Livro newLivro = findById(id);
		updateData(newLivro, livro);
		return livroRepository.save(newLivro);
		
	}
	private void updateData(Livro newLivro, Livro livro) {
		newLivro.setTitulo(livro.getTitulo());
		newLivro.setNome_autor(livro.getNome_autor());
		newLivro.setTexto(livro.getTexto());
		
	}
	public Livro create(Integer id_categoria, Livro livro) {
		livro.setId(null);
		Categoria categoria = categoriaService.findById(id_categoria);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
		
	}
	public void delete(Integer id) {
		Livro livro = findById(id);
		livroRepository.delete(livro);
		
	}
}

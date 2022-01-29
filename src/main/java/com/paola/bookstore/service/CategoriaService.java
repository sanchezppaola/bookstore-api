package com.paola.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paola.bookstore.domain.Categoria;
import com.paola.bookstore.dtos.CategoriaDTO;
import com.paola.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repositoryCategoria.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: " + id + ", Tipo: " + Categoria.class.getName(), null));
		
	}
	
	public List<Categoria> findAll(){
		return repositoryCategoria.findAll();
		 
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return repositoryCategoria.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
		Categoria categoria = findById(id);
		categoria.setNome(categoriaDTO.getNome());
		categoria.setDescricao(categoriaDTO.getDescricao());
		return repositoryCategoria.save(categoria);
		
	}

	public void delete(Integer id) {
		findById(id);
		repositoryCategoria.deleteById(id);
		
	}

}

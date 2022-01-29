package com.paola.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paola.bookstore.domain.Categoria;
import com.paola.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(obj.get(), "Objeto nao encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
		 
	}
}

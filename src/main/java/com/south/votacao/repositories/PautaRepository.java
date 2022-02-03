package com.south.votacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.south.votacao.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>{
	
}
package com.south.votacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.south.votacao.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{

	@Query("SELECT sessao FROM Seessao sessao WHERE sessao.pauta.id = :id_pauta ORDER BY numero_sessao")
	List<Sessao> findAllByPauta(@Param(value = "id_pauta") Integer id_pauta);

}

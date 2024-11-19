package br.edu.infnet.alfredo.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.alfredo.model.domain.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

	List<Medico> findByPrecoConsultaBetween(float precoInicial, float precoFinal);
	
	List<Medico> findByDuracaoConsultaEmMinutosBetween(int duracaoInicial, int duracaoFinal);
}

package br.edu.infnet.alfredo.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;

import br.edu.infnet.alfredo.model.domain.Clinica;

@Repository
public interface ClinicaRepository extends CrudRepository<Clinica, Integer> {

	List<Clinica> findByNomeContaining(String nome, Sort by);

	Iterable<Clinica> findAll(Sort by);

}

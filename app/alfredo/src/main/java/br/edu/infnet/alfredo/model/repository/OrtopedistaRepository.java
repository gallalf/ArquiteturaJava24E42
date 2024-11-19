package br.edu.infnet.alfredo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.alfredo.model.domain.Ortopedista;

@Repository
public interface OrtopedistaRepository extends CrudRepository<Ortopedista, Integer> {

}

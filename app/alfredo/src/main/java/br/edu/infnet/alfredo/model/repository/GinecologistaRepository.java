package br.edu.infnet.alfredo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.alfredo.model.domain.Ginecologista;

@Repository
public interface GinecologistaRepository extends CrudRepository<Ginecologista, Integer> {

}

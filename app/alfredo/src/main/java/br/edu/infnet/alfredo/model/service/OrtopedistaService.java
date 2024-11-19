package br.edu.infnet.alfredo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.alfredo.model.domain.Ortopedista;
import br.edu.infnet.alfredo.model.repository.OrtopedistaRepository;

@Service
public class OrtopedistaService {
	
	@Autowired
	private OrtopedistaRepository ortopedistaRepository;	

	public Collection<Ortopedista> obterLista(){
		return (Collection<Ortopedista>) ortopedistaRepository.findAll();
	}
	
	public void incluir(Ortopedista ortopedista) {
		ortopedistaRepository.save(ortopedista);
	}

	public long obterQtde() {
		return ortopedistaRepository.count();
	}
}

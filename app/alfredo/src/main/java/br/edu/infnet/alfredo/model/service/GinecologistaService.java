package br.edu.infnet.alfredo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.alfredo.Constantes;
import br.edu.infnet.alfredo.exceptions.MedicoNaoEncontradoException;
import br.edu.infnet.alfredo.model.domain.Ginecologista;
import br.edu.infnet.alfredo.model.repository.GinecologistaRepository;

@Service
public class GinecologistaService {

	@Autowired
	private GinecologistaRepository ginecologistaRepository;	

	public Collection<Ginecologista> obterLista(){
		return (Collection<Ginecologista>) ginecologistaRepository.findAll();
	}
	
	public void incluir(Ginecologista ginecologista) {
		ginecologistaRepository.save(ginecologista);
	}

	public Ginecologista alterar(Ginecologista ginecologista) {
		
		if(!ginecologistaRepository.existsById(ginecologista.getId())) {
			throw new MedicoNaoEncontradoException(Constantes.MSG_MEDICO_NOT_FOUND);
		}
		
		return ginecologistaRepository.save(ginecologista);
	}
	
	public long obterQtde() {
		return ginecologistaRepository.count();
	}
}

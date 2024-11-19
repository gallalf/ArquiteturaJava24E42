package br.edu.infnet.alfredo.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.alfredo.Constantes;
import br.edu.infnet.alfredo.exceptions.MedicoNaoEncontradoException;
import br.edu.infnet.alfredo.model.domain.Medico;
import br.edu.infnet.alfredo.model.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;	

	public Collection<Medico> obterLista(){
		return (Collection<Medico>) medicoRepository.findAll();
	}
	
	public void incluir(Medico produto) {
		medicoRepository.save(produto);
	}
	
	public List<Medico> obterListaPorPrecoConsulta(float precoInicial, float precoFinal){
		return medicoRepository.findByPrecoConsultaBetween(precoInicial, precoFinal);
	}
	
	public List<Medico> obterListaPorDuracaoConsulta(int duracaoInicial, int duracaoFinal){
		return medicoRepository.findByDuracaoConsultaEmMinutosBetween(duracaoInicial, duracaoFinal);
	}

	public long obterQtde() {
		return medicoRepository.count();
	}

	public void excluir(Integer id) {
		medicoRepository.deleteById(id);		
	}

	public Medico obterPorId(Integer id) {
		return medicoRepository.findById(id).orElse(null);
	}

	public Medico alterar(Integer id, float precoConsulta) {
		
		Medico medicoExistente = medicoRepository.findById(id).orElseThrow(() -> 
			new MedicoNaoEncontradoException(Constantes.MSG_MEDICO_NOT_FOUND));
		
		medicoExistente.setPrecoConsulta(precoConsulta);
		
		return medicoRepository.save(medicoExistente);
	}
}

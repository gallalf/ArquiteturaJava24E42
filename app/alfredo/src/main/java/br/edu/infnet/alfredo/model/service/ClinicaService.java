package br.edu.infnet.alfredo.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.alfredo.model.domain.Clinica;
import br.edu.infnet.alfredo.model.domain.Endereco;
import br.edu.infnet.alfredo.model.repository.ClinicaRepository;
import org.springframework.data.domain.Sort;

@Service
public class ClinicaService {

	@Autowired
	private ClinicaRepository clinicaRepository;
	
	@Autowired
	private LocalizacaoService localizacaoService;
	
	public Clinica incluir(Clinica clinica) {
		
		String cep = clinica.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		clinica.setEndereco(endereco);

		return clinicaRepository.save(clinica);
	}
	
	public boolean excluir(Integer id) {
		
		if(!clinicaRepository.existsById(id)){
			return false;
		}

		clinicaRepository.deleteById(id);
		
		return true;
	}
	
	public Collection<Clinica> obterLista(){
		return (Collection<Clinica>) clinicaRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public List<Clinica> obterPorNome(String nome){
		return clinicaRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public long obterQtde() {
		return clinicaRepository.count();
	}

	public Clinica obterPorId(Integer id) {
		return clinicaRepository.findById(id).orElse(null);
	}
}

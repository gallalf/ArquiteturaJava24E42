package br.edu.infnet.alfredo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.alfredo.model.domain.Medico;
import br.edu.infnet.alfredo.model.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
		
	@Operation(summary = "Recupera todos os médicos existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public Collection<Medico> obterLista(){
		
		return medicoService.obterLista();
	}

	@Operation(summary = "Filtra médicos pelo preço cobrado pela consulta.")
	@GetMapping(value = "/filtrarPorPrecoConsulta")
	public ResponseEntity<List<Medico>> obterListaPorPrecoConsulta(@RequestParam float min, @RequestParam float max){
		
		if(min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Medico> medicos = medicoService.obterListaPorPrecoConsulta(min, max);
		
		if(medicos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(medicos);
		}
		
		return ResponseEntity.ok(medicos);
	}	
	
	@Operation(summary = "Filtra médicos pela duração da consulta.")
	@GetMapping(value = "/filtrarPorDuracaoConsulta")
	public ResponseEntity<List<Medico>> obterListaPorDuracaoConsulta(@RequestParam int min, @RequestParam int max){
		
		if(min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Medico> medicos = medicoService.obterListaPorDuracaoConsulta(min, max);
		
		if(medicos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(medicos);
		}
		
		return ResponseEntity.ok(medicos);
	}
	
	@Operation(summary = "Exclui um médico através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		medicoService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@Operation(summary = "Busca um médico através do ID.")
	@GetMapping(value = "/{id}")
	public Medico obterPorId(@PathVariable Integer id) {
		return medicoService.obterPorId(id);
	}

	@Operation(summary = "Altera o preço da consulta cobrada por um médico.")
	@PatchMapping(value = "/alterar")
	public ResponseEntity<Medico> alterar(@RequestParam Integer id, @RequestParam float preco) {
		
		Medico medicoAtualizado = medicoService.alterar(id, preco);
		
		return ResponseEntity.ok(medicoAtualizado);
	}
}
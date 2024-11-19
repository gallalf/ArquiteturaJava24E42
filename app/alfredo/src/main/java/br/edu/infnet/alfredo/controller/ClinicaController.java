package br.edu.infnet.alfredo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.alfredo.Constantes;
import br.edu.infnet.alfredo.model.domain.Clinica;
import br.edu.infnet.alfredo.model.service.ClinicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clinicas")
public class ClinicaController {

	@Autowired
	private ClinicaService clinicaService;
	
	@Operation(summary = "Recupera todas as clínicas existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Collection<Clinica>> obterLista(){		
		return ResponseEntity.ok(clinicaService.obterLista());
	}
	
	@Operation(summary = "Inclui uma nova clínica.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Clinica clinica) {
		
		clinicaService.incluir(clinica);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui uma clínica através do ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Clínica não encontrada")
		})
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(clinicaService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLINICA_NOT_FOUND);
	}
	
	@Operation(summary = "Busca uma clínica através do nome.")
	@GetMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Clinica>> obterPorNome(@PathVariable String nome){
		
		List<Clinica> clinicas = clinicaService.obterPorNome(nome);
		
		if(clinicas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clinicas);
		}
		
		return ResponseEntity.ok(clinicas);
	}	
	
	@Operation(summary = "Busca uma clínica através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Clinica> obterPorId(@PathVariable Integer id) {
		
		Clinica clinica = clinicaService.obterPorId(id);
		
		if(clinica == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(clinica);
	}
}

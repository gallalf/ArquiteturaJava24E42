package br.edu.infnet.alfredo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.alfredo.Constantes;
import br.edu.infnet.alfredo.model.domain.Ortopedista;
import br.edu.infnet.alfredo.model.service.OrtopedistaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ortopedistas")
public class OrtopedistaController {

	@Autowired
	private OrtopedistaService ortopedistaService;
		
	@Operation(summary = "Recupera todos os médicos ortopedistas existentes.")
	@GetMapping
	public ResponseEntity<Collection<Ortopedista>> obterLista(){
		
		return ResponseEntity.ok(ortopedistaService.obterLista());
	}

	@Operation(summary = "Inclui um novo médico ortopedista.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Ortopedista ortopedista) {
		
		ortopedistaService.incluir(ortopedista);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
}
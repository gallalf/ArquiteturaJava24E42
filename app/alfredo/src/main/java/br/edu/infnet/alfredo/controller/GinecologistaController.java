package br.edu.infnet.alfredo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.alfredo.Constantes;
import br.edu.infnet.alfredo.model.domain.Ginecologista;
import br.edu.infnet.alfredo.model.service.GinecologistaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ginecologistas")
public class GinecologistaController {

	@Autowired
	private GinecologistaService ginecologistaService;
		
	@Operation(summary = "Recupera todos os médicos ginecologistas existentes.")
	@GetMapping
	public ResponseEntity<Collection<Ginecologista>> obterLista(){
		
		return ResponseEntity.ok(ginecologistaService.obterLista());
	}

	@Operation(summary = "Inclui um novo ginecologista.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Ginecologista ginecologista) {
		
		ginecologistaService.incluir(ginecologista);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Altera o registro completo de um ginecologista.")
	@PutMapping(value = "/alterar")
	public ResponseEntity<Ginecologista> alterar(@RequestBody Ginecologista ginecologista) {
		
		Ginecologista ginecologistaAtualizado = ginecologistaService.alterar(ginecologista);
		
		return ResponseEntity.ok(ginecologistaAtualizado);
	}
}
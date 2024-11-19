package br.edu.infnet.alfredo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.alfredo.model.service.ClinicaService;
import br.edu.infnet.alfredo.model.service.GinecologistaService;
import br.edu.infnet.alfredo.model.service.MedicoService;
import br.edu.infnet.alfredo.model.service.OrtopedistaService;

@Controller
public class AppController {
	
	@Autowired
	private ClinicaService clinicaService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private GinecologistaService ginecologistaService;
	@Autowired
	private OrtopedistaService ortopedistaService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeClinica", clinicaService.obterQtde());
		model.addAttribute("qtdeMedico", medicoService.obterQtde());
		model.addAttribute("qtdeGinecologista", ginecologistaService.obterQtde());
		model.addAttribute("qtdeOrtopedista", ortopedistaService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/clinica/listagem")
	public String vendedorLista(Model model) {
				
		model.addAttribute("titulo", "Listagem de clínicas médicas");
		model.addAttribute("listagem", clinicaService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/medico/listagem")
	public String produtoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de médicos");
		model.addAttribute("listagem", medicoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/ortopedista/listagem")
	public String eletronicoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de médicos ortopedistas");
		model.addAttribute("listagem", ortopedistaService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/ginecologista/listagem")
	public String alimenticioLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de médicos ginecologistas");
		model.addAttribute("listagem", ginecologistaService.obterLista());
		
		return telaHome(model);
	}
}

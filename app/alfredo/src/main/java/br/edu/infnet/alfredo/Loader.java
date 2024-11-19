package br.edu.infnet.alfredo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.alfredo.model.domain.Clinica;
import br.edu.infnet.alfredo.model.domain.Endereco;
import br.edu.infnet.alfredo.model.domain.Estado;
import br.edu.infnet.alfredo.model.domain.Ginecologista;
import br.edu.infnet.alfredo.model.domain.Municipio;
import br.edu.infnet.alfredo.model.domain.Ortopedista;
import br.edu.infnet.alfredo.model.service.ClinicaService;
import br.edu.infnet.alfredo.model.service.LocalizacaoService;
import br.edu.infnet.alfredo.model.service.MedicoService;

@Component
public class Loader implements ApplicationRunner {

	@Autowired
	private ClinicaService clinicaService;
	@Autowired
	private LocalizacaoService localizacaoService;
	@Autowired
	private MedicoService medicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(Estado estado : localizacaoService.obterEstados()) {
			System.out.println("ESTADO: " + estado.getNome());
		}

		for(Municipio municipio : localizacaoService.obterMunicipios(33)) {
			System.out.println("MUNICÍPIO: " + municipio.getNome());
		}

		FileReader file = new FileReader("files/clinicas.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		Clinica clinica = null;

		while(linha != null) {

			String[] campos = linha.split(";");

			switch (campos[0].toUpperCase()) {
			case "C":
				clinica = new Clinica();
				clinica.setNome(campos[1]);
				clinica.setCnpj(campos[2]);
				clinica.setTelefone(campos[3]);
				clinica.setEndereco(new Endereco(campos[4]));
				clinica.setMedicos(new ArrayList<>());

				clinica = clinicaService.incluir(clinica);

				System.out.println("CLINICA ["+clinica+"]");

				break;

			case "G":
				Ginecologista ginecologista = new Ginecologista();
				ginecologista.setNome(campos[1]);
				ginecologista.setCrm(Integer.valueOf(campos[2]));
				ginecologista.setPrecoConsulta(Float.valueOf(campos[3]));
				ginecologista.setDuracaoConsultaEmMinutos(Integer.valueOf(campos[4]));
				ginecologista.setFazParto(Boolean.valueOf(campos[5]));
				ginecologista.setColocaDiu(Boolean.valueOf(campos[6]));

				medicoService.incluir(ginecologista);

				clinica.getMedicos().add(ginecologista);

				break;

			case "O":
				Ortopedista ortopedista = new Ortopedista();
				ortopedista.setNome(campos[1]);
				ortopedista.setCrm(Integer.valueOf(campos[2]));
				ortopedista.setPrecoConsulta(Float.valueOf(campos[3]));
				ortopedista.setDuracaoConsultaEmMinutos(Integer.valueOf(campos[4]));
				ortopedista.setSubEspecialidade(campos[5]);
				ortopedista.setFazCirurgia(Boolean.valueOf(campos[6]));

				medicoService.incluir(ortopedista);

				clinica.getMedicos().add(ortopedista);

				break;

			default:
				break;
			}

			linha = leitura.readLine();
		}

		for(Clinica c: clinicaService.obterLista()) {
			System.out.println("Clinica cadastrada com sucesso: " + c);
		}

		leitura.close();
	}
}
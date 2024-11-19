package br.edu.infnet.alfredo.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TOrtopedista")
public class Ortopedista extends Medico {

	private String subEspecialidade;
	private boolean fazCirurgia;
	
	public String getSubEspecialidade() {
		return subEspecialidade;
	}
	public void setSubEspecialidade(String subEspecialidade) {
		this.subEspecialidade = subEspecialidade;
	}
	public boolean isFazCirurgia() {
		return fazCirurgia;
	}
	public void setFazCirurgia(boolean fazCirurgia) {
		this.fazCirurgia = fazCirurgia;
	}
}

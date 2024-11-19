package br.edu.infnet.alfredo.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TGinecologista")
public class Ginecologista extends Medico {

	private boolean fazParto;
	private boolean colocaDiu;

	public boolean isFazParto() {
		return fazParto;
	}
	public void setFazParto(boolean fazParto) {
		this.fazParto = fazParto;
	}
	public boolean isColocaDiu() {
		return colocaDiu;
	}
	public void setColocaDiu(boolean colocaDiu) {
		this.colocaDiu = colocaDiu;
	}
}

package br.edu.infnet.alfredo.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TMedico")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome do médico é obrigatório.")
	private String nome;
	
	private int crm;
	
	@DecimalMin(value = "0.1", message = "O preço da consulta deve ser maior que zero.")
	private float precoConsulta;
	
	@Min(value = 15, message = "A duração da consulta deve ser de pelo menos 15 minutos")
	private int duracaoConsultaEmMinutos;
	
	@ManyToOne
	@JoinColumn(name = "idClinica")
	@JsonBackReference
	private Clinica clinica;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public float getPrecoConsulta() {
		return precoConsulta;
	}
	public void setPrecoConsulta(float precoConsulta) {
		this.precoConsulta = precoConsulta;
	}
	public int getDuracaoConsultaEmMinutos() {
		return duracaoConsultaEmMinutos;
	}
	public void setDuracaoConsultaEmMinutos(int duracaoConsultaEmMinutos) {
		this.duracaoConsultaEmMinutos = duracaoConsultaEmMinutos;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Clinica getClinica() {
		return clinica;
	}
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	@Override
	public String toString() {
		return String.format("Nome: %s - CRM: %d - Preço da consulta: %.2f - Duração da consulta: %d",
				nome,
				crm,
				precoConsulta,
				duracaoConsultaEmMinutos
			);
	}
}

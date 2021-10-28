package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartamentoID")
	private Integer departamentoID;

	@Column(name = "Nome")
	private String nome;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "Inclusao", nullable = true)
	private Date inclusao;

	public Departamento() {

	}

	

	public Integer getDepartamentoID() {
		return departamentoID;
	}



	public void setDepartamentoID(Integer departamentoID) {
		this.departamentoID = departamentoID;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getInclusao() {
		return inclusao;
	}



	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}



	public Departamento(Integer departamentoID, String nome, Date inclusao) {
		super();
		this.departamentoID = departamentoID;
		this.nome = nome;
		this.inclusao = inclusao;
	}

	@Override
	public String toString() {
		return "Departamento [departamentoID=" + departamentoID + ", nome=" + nome + ", inclusao="
				+ inclusao + "]";
	}
	
	
}
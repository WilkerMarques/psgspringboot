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
@Table(name = "FuncionarioPorDepartamento")
public class FuncionarioPorDepartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FuncionarioPorDepartamentoID")
	private Integer funcionarioPorDepartamentoID;
    
	
	@Column(name = "FuncionarioID")
	private Integer funcionarioID;

	@Column(name = "DepartamentoID")
	private Integer departamentoID;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "EntradaDepartamento", nullable = true)
	private Date entradaDepartamento;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "SaidaDepartamento", nullable = true)
	private Date saidaDepartamento;

	public FuncionarioPorDepartamento() {

	}

	public FuncionarioPorDepartamento(Integer funcionarioPorDepartamentoID, Integer funcionarioID,
			Integer departamentoID, Date entradaDepartamento, Date saidaDepartamento) {
		super();
		this.funcionarioPorDepartamentoID = funcionarioPorDepartamentoID;
		this.funcionarioID = funcionarioID;
		this.departamentoID = departamentoID;
		this.entradaDepartamento = entradaDepartamento;
		this.saidaDepartamento = saidaDepartamento;
	}

	public Integer getFuncionarioPorDepartamentoID() {
		return funcionarioPorDepartamentoID;
	}

	public void setFuncionarioPorDepartamentoID(Integer funcionarioPorDepartamentoID) {
		this.funcionarioPorDepartamentoID = funcionarioPorDepartamentoID;
	}

	public Integer getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(Integer funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

	public Integer getDepartamentoID() {
		return departamentoID;
	}

	public void setDepartamentoID(Integer departamentoID) {
		this.departamentoID = departamentoID;
	}

	public Date getEntradaDepartamento() {
		return entradaDepartamento;
	}

	public void setEntradaDepartamento(Date entradaDepartamento) {
		this.entradaDepartamento = entradaDepartamento;
	}

	public Date getSaidaDepartamento() {
		return saidaDepartamento;
	}

	public void setSaidaDepartamento(Date saidaDepartamento) {
		this.saidaDepartamento = saidaDepartamento;
	}

	@Override
	public String toString() {
		return "FuncionarioPorDepartamento [funcionarioPorDepartamentoID=" + funcionarioPorDepartamentoID
				+ ", funcionarioID=" + funcionarioID + ", departamentoID=" + departamentoID
				+ ", entradaDepartamento=" + entradaDepartamento + ", saidaDepartamento=" + saidaDepartamento + "]";

	}
}
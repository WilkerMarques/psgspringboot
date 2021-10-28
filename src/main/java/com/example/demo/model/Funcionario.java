package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

	
	@Column(name = "Chave")
	private Long chave;
	
	@Id
	@Column(name = "FuncionarioID")
	private Integer funcionarioID;

	@Column(name = "Nome")
	private String nome;

	@Column(name = "Sobrenome")
	private String sobrenome;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "Admissao")
	private Date dataDeAdmissao;
	
	@Column(name = "Sexo")
	private String sexo;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "Nascimento")
	private Date dataDeNascimento;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "CTPS")
	private String ctps;
	
	@Column(name = "CTPSNum")
	private Long ctpsNum;
	
	@Column(name = "CTPSSerie")
	private Integer ctpsSerie;
	
	@Column(name = "PaisID")
	private Integer paisID;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "Inclusao", nullable = true)
	private Date dataDeInclusao;

	public Funcionario() {

	}

	public Funcionario(Long chave, Integer funcionarioID, String nome, String sobrenome, Date dataDeAdmissao, String sexo,
			Date dataDeNascimento, String email, String ctps, Long ctpsNum, Integer ctpsSerie, Integer paisID,
			Date dataDeInclusao) {
		super();
		this.chave = chave;
		this.funcionarioID = funcionarioID;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataDeAdmissao = dataDeAdmissao;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
		this.ctps = ctps;
		this.ctpsNum = ctpsNum;
		this.ctpsSerie = ctpsSerie;
		this.paisID = paisID;
		this.dataDeInclusao = dataDeInclusao;
	}

	public Long getChave() {
		return chave;
	}

	public void setChave(Long chave) {
		this.chave = chave;
	}

	public Integer getFuncionarioID() {
		return funcionarioID;
	}

	public void setFuncionarioID(Integer funcionarioID) {
		this.funcionarioID = funcionarioID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(Date dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public Long getCtpsNum() {
		return ctpsNum;
	}

	public void setCtpsNum(Long ctpsNum) {
		this.ctpsNum = ctpsNum;
	}

	public Integer getCtpsSerie() {
		return ctpsSerie;
	}

	public void setCtpsSerie(Integer ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}

	public Date getDataDeInclusao() {
		return dataDeInclusao;
	}

	public void setDataDeInclusao(Date dataDeInclusao) {
		this.dataDeInclusao = dataDeInclusao;
	}

	@Override
	public String toString() {
		return "Funcionario [chave=" + chave + ", funcionarioID=" + funcionarioID + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", dataDeAdmissao=" + dataDeAdmissao + ", sexo=" + sexo 
				+ ", dataDeNascimento=" + dataDeNascimento + ", email=" + email + ", ctps=" + ctps 
				+ ", ctpsNum=" + ctpsNum + ", ctpsSerie=" + ctpsSerie + ", paisID=" + paisID 
				+ ", dataDeInclusao=" + dataDeInclusao + "]";
	}
	
	
}
	
	


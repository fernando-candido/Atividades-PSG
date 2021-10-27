package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartamentoID")
	private Integer departamentoID;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Inclusao", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date dataDeInclusao;
	
	public Departamento () {}

	
	
	public Departamento(Integer departamentoID, String nome, Date dataDeInclusao) {
		super();
		this.departamentoID = departamentoID;
		this.nome = nome;
		this.dataDeInclusao = dataDeInclusao;
	}



	@Override
	public String toString() {
		return "Departamento [departamentoID=" + departamentoID + ", nome=" + nome + ", dataDeInclusao="
				+ dataDeInclusao + "]";
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

	public Date getDataDeInclusao() {
		return dataDeInclusao;
	}

	public void setDataDeInclusao(Date dataDeInclusao) {
		this.dataDeInclusao = dataDeInclusao;
	}
	
	

}


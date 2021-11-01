package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Idiomas")

public class Idioma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idiomaID;

	@Column(name = "ABREVIADO")
	private String abreviado;

	@Column(name = "DESCR")
	private String descricao;

	public Integer getIdiomaID() {
		return idiomaID;
	}

	public Idioma() {
	}

	public void setIdiomaID(Integer idiomaID) {
		this.idiomaID = idiomaID;
	}

	public String getAbreviado() {
		return abreviado;
	}

	public void setAbreviado(String abreviado) {
		this.abreviado = abreviado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Idioma [idiomaID=" + idiomaID + ", abreviado=" + abreviado + ", descricao=" + descricao + "]";
	}

	public Idioma(Integer idiomaID, String abreviado, String descricao) {
		super();
		this.idiomaID = idiomaID;
		this.abreviado = abreviado;
		this.descricao = descricao;
	}

}

package com.trabalho.poo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends GenericEntity{


	@Column(name = "descricao")
	private String descricao;
	@Column(name = "unidade_medida")
	private String unidadeMedida;
	@Column(name = "valor_unitario")
	private double valorUnitario;

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}

	public String getUnidadeMedida(){
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida){
		this.unidadeMedida = unidadeMedida;
	}
	
	
}

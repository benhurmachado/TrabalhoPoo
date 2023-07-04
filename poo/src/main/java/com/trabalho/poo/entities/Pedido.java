package com.trabalho.poo.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido extends GenericEntity{

    @Column(name = "data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "produto")
    private Produto produto;

    @Column(name = "quantidade")
    private double quantidade;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public double getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }
}

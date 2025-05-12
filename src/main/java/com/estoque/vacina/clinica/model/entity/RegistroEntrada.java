package com.estoque.vacina.clinica.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="registro_entrada")
public class RegistroEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_entrada")
    protected UUID id;

    @ManyToOne
    @JoinColumn(name="id_produto")
    protected Produto produto;

    @ManyToOne
    @JoinColumn(name="id_fornecedor")
    protected Fornecedor fornecedor;

    @Column(name = "quantidade", nullable = false)
    protected Long quantidade;

    @Column(name = "data_entrada", nullable = false)
    protected LocalDate dataEntrada;

    public RegistroEntrada(){}

    public RegistroEntrada(Produto produto, Fornecedor fornecedor, Long quantidade, LocalDate dataEntrada) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
    }

    public UUID getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}

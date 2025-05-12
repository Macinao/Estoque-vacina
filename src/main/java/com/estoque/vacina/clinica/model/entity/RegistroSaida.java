package com.estoque.vacina.clinica.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="registro_saida")
public class RegistroSaida {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_saida")
    protected UUID id;

    @ManyToOne
    @JoinColumn(name="id_produto")
    protected Produto produto;

    @Column(name="quantidade", nullable = false)
    protected Long quantidade;

    @Column(name="data_saida", nullable = false)
    protected LocalDate dataSaida;

    public RegistroSaida(){}

    public RegistroSaida(Produto produto, Long quantidade, LocalDate dataSaida) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
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

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
}

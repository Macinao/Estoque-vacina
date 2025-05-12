package com.estoque.vacina.clinica.model.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_fornecedor")
    private UUID id;

    @Column(name="nome", nullable = false)
    private String nome;

    public Fornecedor() {}

    public Fornecedor(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

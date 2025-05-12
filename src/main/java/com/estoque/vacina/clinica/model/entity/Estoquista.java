package com.estoque.vacina.clinica.model.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="estoquista")
public class Estoquista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_estoquista")
    private UUID id;

    @Column(name="nome", nullable = false)
    private String nome;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    public Estoquista(){}

    public Estoquista(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

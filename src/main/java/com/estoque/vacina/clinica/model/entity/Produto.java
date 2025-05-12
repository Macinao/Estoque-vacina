package com.estoque.vacina.clinica.model.entity;
import jakarta.persistence.*;
import java.util.UUID;

    @Entity
    @Table(name="produto")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name="id_produto")
        private UUID id;

        @ManyToOne
        @JoinColumn(name="id_fornecedor")
        private Fornecedor fornecedor;

        @Column(name="nome", nullable = false)
        private String nome;

        @Column(name="quantidade", nullable = false)
        private Long quantidade;

        public Produto() {}

        public Produto(Fornecedor fornecedor, String nome, Long quantidade) {
            this.fornecedor = fornecedor;
            this.nome = nome;
            this.quantidade = quantidade;
        }

        public UUID getId() {
            return id;
        }

        public Fornecedor getFornecedor() {
            return fornecedor;
        }

        public void setFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Long getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Long quantidade) {
            this.quantidade = quantidade;
        }
    }

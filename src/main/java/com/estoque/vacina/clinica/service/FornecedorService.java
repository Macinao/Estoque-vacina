package com.estoque.vacina.clinica.service;

import com.estoque.vacina.clinica.model.DTO.FornecedorRecordDTO;
import com.estoque.vacina.clinica.model.entity.Fornecedor;
import java.util.List;
import java.util.UUID;

public interface FornecedorService {
    public Fornecedor registrarFornecedor(
            FornecedorRecordDTO fornecedorRecordDTO);
    public Fornecedor buscarFornecedorPorId(
            UUID idFornecedor);
    public List<Fornecedor> listarFornecedores();
    public String deletarFornecedor(
            UUID idFornecedor);
    public Fornecedor atualizarFornecedor(
            UUID idFornecedor,
            FornecedorRecordDTO fornecedorRecordDTO);
}

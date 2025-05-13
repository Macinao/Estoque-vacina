package com.estoque.vacina.clinica.service;

import com.estoque.vacina.clinica.model.DTO.ProdutoRecordDTO;
import com.estoque.vacina.clinica.model.entity.Produto;
import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    public Produto registrarProduto(
            ProdutoRecordDTO produtoRecordDTO);
    public Produto buscarProdutoPorId(
            UUID idProduto);
    public List<Produto> listarProdutos();
    public String deletarProduto(
            UUID idProduto);
    public Produto atualizarProduto(
            UUID idProduto,
            ProdutoRecordDTO produtoRecordDTO);
}

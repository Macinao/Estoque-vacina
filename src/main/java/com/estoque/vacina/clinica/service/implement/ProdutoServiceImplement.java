package com.estoque.vacina.clinica.service.implement;

import com.estoque.vacina.clinica.model.DTO.ProdutoRecordDTO;
import com.estoque.vacina.clinica.model.entity.Fornecedor;
import com.estoque.vacina.clinica.model.entity.Produto;
import com.estoque.vacina.clinica.repository.FornecedorRepository;
import com.estoque.vacina.clinica.repository.ProdutoRepository;
import com.estoque.vacina.clinica.service.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProdutoServiceImplement implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public Produto registrarProduto(ProdutoRecordDTO produtoRecordDTO) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoRecordDTO, produto);

        Fornecedor fornecedor = fornecedorRepository.findById(produtoRecordDTO.idFornecedor())
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado ao criar produto."));
        produto.setFornecedor(fornecedor);

        return produtoRepository.save(produto);
    }

    @Override
    public Produto buscarProdutoPorId(UUID idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public String deletarProduto(UUID idProduto) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado ao deletar"));
        produtoRepository.delete(produto);

        return "Produto deletado!";
    }

    @Override
    public Produto atualizarProduto(UUID idProduto, ProdutoRecordDTO produtoRecordDTO) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado ao atualizar produto."));
        BeanUtils.copyProperties(produtoRecordDTO, produto);

        Fornecedor fornecedor = fornecedorRepository.findById(produtoRecordDTO.idFornecedor())
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor não encontrado ao atualizar produto."));
        produto.setFornecedor(fornecedor);

        return produtoRepository.save(produto);
    }
}

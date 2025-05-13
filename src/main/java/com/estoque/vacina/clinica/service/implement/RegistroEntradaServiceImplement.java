package com.estoque.vacina.clinica.service.implement;

import com.estoque.vacina.clinica.model.DTO.RegistroEntradaRecordDTO;
import com.estoque.vacina.clinica.model.entity.Fornecedor;
import com.estoque.vacina.clinica.model.entity.Produto;
import com.estoque.vacina.clinica.model.entity.RegistroEntrada;
import com.estoque.vacina.clinica.repository.FornecedorRepository;
import com.estoque.vacina.clinica.repository.ProdutoRepository;
import com.estoque.vacina.clinica.repository.RegistroEntradaRepository;
import com.estoque.vacina.clinica.service.RegistroEntradaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RegistroEntradaServiceImplement implements RegistroEntradaService {
    @Autowired
    RegistroEntradaRepository registroEntradaRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public RegistroEntrada registrarEntrada(RegistroEntradaRecordDTO registroEntradaRecordDTO) {
        RegistroEntrada registroEntrada = new RegistroEntrada();
        BeanUtils.copyProperties(registroEntradaRecordDTO, registroEntrada);
        registroEntrada.setDataEntrada(registroEntradaRecordDTO.data());

        Fornecedor fornecedor = fornecedorRepository.findById(registroEntradaRecordDTO.fornecedor())
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado ao criar registro de entrada."));
        registroEntrada.setFornecedor(fornecedor);

        Produto produto = produtoRepository.findById(registroEntradaRecordDTO.produto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado ao criar registro de entrada."));
        registroEntrada.setProduto(produto);

        produto.setQuantidade(produto.getQuantidade() + registroEntradaRecordDTO.quantidade());
        produtoRepository.save(produto);

        return registroEntradaRepository.save(registroEntrada);
    }

    @Override
    public RegistroEntrada buscarRegistroEntradaPorId(UUID idRegistroEntrada) {
        return registroEntradaRepository.findById(idRegistroEntrada)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado ao criar registro de entrada."));
    }

    @Override
    public List<RegistroEntrada> listarRegistrosEntradas() {
        return registroEntradaRepository.findAll();
    }

    @Override
    public String deletarRegistroEntrada(UUID idRegistroEntrada) {
        RegistroEntrada registroEntrada = registroEntradaRepository.findById(idRegistroEntrada)
                .orElseThrow(() -> new IllegalArgumentException("Registro de entrada não encontrado ao deletar de registro de entrada."));
        registroEntradaRepository.delete(registroEntrada);

        return "RegistroEntrada deletado!";
    }

    @Override
    public RegistroEntrada atualizarRegistroEntrada(UUID idRegistroEntrada,
                                                    RegistroEntradaRecordDTO registroEntradaRecordDTO) {
        RegistroEntrada registroEntrada = registroEntradaRepository.findById(idRegistroEntrada)
                .orElseThrow(() -> new EntityNotFoundException("Registro de entrada não encontrado."));

        registroEntrada.setDataEntrada(registroEntradaRecordDTO.data());

        Fornecedor fornecedor = fornecedorRepository.findById(registroEntradaRecordDTO.fornecedor())
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));
        registroEntrada.setFornecedor(fornecedor);

        Produto produto = produtoRepository.findById(registroEntradaRecordDTO.produto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
        registroEntrada.setProduto(produto);

        long diferencaQuantidade = registroEntradaRecordDTO.quantidade() - registroEntrada.getQuantidade();
        long novaQuantidade = produto.getQuantidade() + diferencaQuantidade;
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Quantidade do produto não pode ser negativa.");
        }
        produto.setQuantidade(novaQuantidade);
        registroEntrada.setQuantidade(registroEntradaRecordDTO.quantidade());
        produtoRepository.save(produto);

        return registroEntradaRepository.save(registroEntrada);
    }
}

package com.estoque.vacina.clinica.service.implement;

import com.estoque.vacina.clinica.model.DTO.FornecedorRecordDTO;
import com.estoque.vacina.clinica.model.entity.Fornecedor;
import com.estoque.vacina.clinica.repository.FornecedorRepository;
import com.estoque.vacina.clinica.service.FornecedorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FornecedorServiceImplement implements FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor registrarFornecedor(
            FornecedorRecordDTO fornecedorRecordDTO) {
        Fornecedor novoFornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorRecordDTO, novoFornecedor);

        return fornecedorRepository.save(novoFornecedor);
    }

    @Override
    public Fornecedor buscarFornecedorPorId(UUID idFornecedor) {
        return fornecedorRepository.findById(idFornecedor)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public String deletarFornecedor(UUID idFornecedor) {
        Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado ao deletar"));

        fornecedorRepository.delete(fornecedor);
        return "Fornecedor deletado.";
    }

    @Override
    public Fornecedor atualizarFornecedor(
            UUID idFornecedor,
            FornecedorRecordDTO fornecedorRecordDTO) {
        Fornecedor fornecedorAtualizado = fornecedorRepository.findById(idFornecedor)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));
        BeanUtils.copyProperties(fornecedorRecordDTO, fornecedorAtualizado);

        return fornecedorAtualizado;
    }
}

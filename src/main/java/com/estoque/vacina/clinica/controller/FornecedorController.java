package com.estoque.vacina.clinica.controller;

import com.estoque.vacina.clinica.model.DTO.FornecedorRecordDTO;
import com.estoque.vacina.clinica.model.entity.Fornecedor;
import com.estoque.vacina.clinica.service.implement.FornecedorServiceImplement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorServiceImplement fornecedorServiceImplement;

    @PostMapping
    public ResponseEntity<Fornecedor> registrarFornecedor(@RequestBody @Valid FornecedorRecordDTO fornecedorRecordDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorServiceImplement.registrarFornecedor(fornecedorRecordDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorId(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorServiceImplement.buscarFornecedorPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorServiceImplement.listarFornecedores());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFornecedor(@PathVariable(value = "id") UUID idFornecedor) {
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorServiceImplement.deletarFornecedor(idFornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarFornecedor(@PathVariable(value = "id") UUID idFornecedor,
                                                      @RequestBody @Valid FornecedorRecordDTO fornecedorRecordDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(fornecedorServiceImplement.atualizarFornecedor(idFornecedor, fornecedorRecordDTO));
    }
}
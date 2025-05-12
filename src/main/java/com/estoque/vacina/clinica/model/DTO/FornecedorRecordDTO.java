package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotBlank;

public record FornecedorRecordDTO(@NotBlank String nome) {
}

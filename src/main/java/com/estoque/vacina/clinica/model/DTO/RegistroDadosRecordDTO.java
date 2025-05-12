package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotBlank;

public record RegistroDadosRecordDTO(@NotBlank String nome,
                                     @NotBlank Long quantidade) {
}

package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotBlank;

public record EstoquistaRecordDRO(@NotBlank String nome,
                                  @NotBlank String email,
                                  @NotBlank String password) {
}

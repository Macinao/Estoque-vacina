package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record RegistroEntradaRecordDTO(@NotNull UUID produto,
                                       @NotNull UUID fornecedor,
                                       @NotNull Long quantidade,
                                       @NotNull LocalDate data) {
}

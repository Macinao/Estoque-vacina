package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record RegistroMovimentacaoRecordDTO(@NotBlank String nome,
                                            @NotNull Long quantidade,
                                            @NotNull LocalDate data) {
}

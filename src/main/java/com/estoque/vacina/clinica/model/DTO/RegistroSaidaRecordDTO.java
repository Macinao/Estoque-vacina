package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record RegistroSaidaRecordDTO(@NotNull UUID idProduto,
                                     @NotNull Long quantidade,
                                     @NotNull LocalDate dataSaida) {
}

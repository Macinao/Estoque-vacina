package com.estoque.vacina.clinica.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ProdutoRecordDTO(@NotNull UUID idFornecedor,
                               @NotBlank String nome,
                               @NotNull Long quantidade) {
}

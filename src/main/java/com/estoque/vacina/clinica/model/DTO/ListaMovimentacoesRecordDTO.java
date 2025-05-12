package com.estoque.vacina.clinica.model.DTO;

import com.estoque.vacina.clinica.model.entity.RegistroEntrada;
import com.estoque.vacina.clinica.model.entity.RegistroSaida;
import java.util.List;

public record ListaMovimentacoesRecordDTO(List<RegistroSaida> saidas,
                                          List<RegistroEntrada> entradas) {
}

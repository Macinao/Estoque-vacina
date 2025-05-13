package com.estoque.vacina.clinica.service;

import com.estoque.vacina.clinica.model.DTO.RegistroSaidaRecordDTO;
import com.estoque.vacina.clinica.model.entity.RegistroSaida;
import java.util.List;
import java.util.UUID;

public interface RegistroSaidaService {
    public RegistroSaida registrarSaida(
            RegistroSaidaRecordDTO registroSaidaRecordDTO);
    public RegistroSaida buscarRegistroSaidaPorId(
            UUID idRegistroSaida);
    public List<RegistroSaida> listarRegistrosSaidas();
    public String deletarRegistroSaida(
            UUID idRegistroSaida);
    public RegistroSaida atualizarRegistroSaida(
            UUID idRegistroSaida,
            RegistroSaidaRecordDTO registroSaidaRecordDTO);
}

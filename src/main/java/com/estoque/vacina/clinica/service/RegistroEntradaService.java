package com.estoque.vacina.clinica.service;

import com.estoque.vacina.clinica.model.DTO.RegistroEntradaRecordDTO;
import com.estoque.vacina.clinica.model.entity.RegistroEntrada;
import java.util.List;
import java.util.UUID;

public interface RegistroEntradaService {
    public RegistroEntrada registrarEntrada(
            RegistroEntradaRecordDTO registroEntradaRecordDTO);
    public RegistroEntrada buscarRegistroEntradaPorId(
            UUID idRegistroEntrada);
    public List<RegistroEntrada> listarRegistrosEntradas();
    public String deletarRegistroEntrada(
            UUID idRegistroEntrada);
    public RegistroEntrada atualizarRegistroEntrada(
            UUID idRegistroEntrada,
            RegistroEntradaRecordDTO registroEntradaRecordDTO);
}

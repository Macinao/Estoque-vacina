package com.estoque.vacina.clinica.service.implement;

import com.estoque.vacina.clinica.model.DTO.RegistroSaidaRecordDTO;
import com.estoque.vacina.clinica.model.entity.RegistroSaida;
import com.estoque.vacina.clinica.service.RegistroSaidaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RegistroSaidaImplement implements RegistroSaidaService {

    @Override
    public RegistroSaida registrarSaida(RegistroSaidaRecordDTO registroSaidaRecordDTO) {
        return null;
    }

    @Override
    public RegistroSaida buscarRegistroSaidaPorId(UUID idRegistroSaida) {
        return null;
    }

    @Override
    public List<RegistroSaida> listarRegistrosSaidas() {
        return null;
    }

    @Override
    public String deletarRegistroSaida(UUID idRegistroSaida) {
        return null;
    }

    @Override
    public RegistroSaida atualizarRegistroSaida(UUID idRegistroSaida, RegistroSaidaRecordDTO registroSaidaRecordDTO) {
        return null;
    }
}

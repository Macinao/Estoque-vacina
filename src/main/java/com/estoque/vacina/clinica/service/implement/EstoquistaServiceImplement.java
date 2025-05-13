package com.estoque.vacina.clinica.service.implement;

import com.estoque.vacina.clinica.model.DTO.EstoquistaRecordDRO;
import com.estoque.vacina.clinica.model.entity.Estoquista;
import com.estoque.vacina.clinica.repository.EstoquistaRepository;
import com.estoque.vacina.clinica.service.EstoquistaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EstoquistaServiceImplement implements EstoquistaService {
    @Autowired
    EstoquistaRepository estoquistaRepository;
    @Override
    public Estoquista registrarEstoquista(EstoquistaRecordDRO estoquistaRecordDRO) {
        Estoquista estoquista = new Estoquista();
        BeanUtils.copyProperties(estoquistaRecordDRO, estoquista);

        return estoquistaRepository.save(estoquista);
    }

    @Override
    public Estoquista buscarEstoquistaPorId(UUID idEstoquista) {
        return estoquistaRepository.findById(idEstoquista)
                .orElseThrow(() -> new EntityNotFoundException("Estoquista não encontrado."));
    }

    @Override
    public List<Estoquista> listarEstoquistas() {
        return estoquistaRepository.findAll();
    }

    @Override
    public String deletarEstoquista(UUID idEstoquista) {
        Estoquista estoquista = estoquistaRepository.findById(idEstoquista)
                .orElseThrow(() -> new EntityNotFoundException("Estoquista não encontrado."));
        estoquistaRepository.delete(estoquista);

        return "Estoquista deletado!";
    }

    @Override
    public Estoquista atualizarEstoquista(UUID idEstoquista, EstoquistaRecordDRO estoquistaRecordDRO) {
        Estoquista estoquista = estoquistaRepository.findById(idEstoquista)
                .orElseThrow(() -> new EntityNotFoundException("Estoquista não encontrado."));
        estoquistaRepository.delete(estoquista);
        BeanUtils.copyProperties(estoquistaRecordDRO, estoquista);

        return estoquistaRepository.save(estoquista);
    }
}

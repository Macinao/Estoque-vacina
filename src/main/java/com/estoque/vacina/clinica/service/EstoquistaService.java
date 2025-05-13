package com.estoque.vacina.clinica.service;

import com.estoque.vacina.clinica.model.DTO.EstoquistaRecordDRO;
import com.estoque.vacina.clinica.model.entity.Estoquista;
import java.util.List;
import java.util.UUID;

public interface EstoquistaService {
    public Estoquista registrarEstoquista(
            EstoquistaRecordDRO estoquistaRecordDRO);
    public Estoquista buscarEstoquistaPorId(
            UUID idEstoquista);
    public List<Estoquista> listarEstoquistas();
    public String deletarEstoquista(
            UUID idEstoquista);
    public Estoquista atualizarEstoquista(
            UUID idEstoquista,
            EstoquistaRecordDRO estoquistaRecordDRO);
}

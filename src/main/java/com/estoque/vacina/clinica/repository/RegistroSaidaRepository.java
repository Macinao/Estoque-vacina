package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.RegistroSaida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RegistroSaidaRepository  extends JpaRepository<RegistroSaida, UUID> {
}

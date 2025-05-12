package com.estoque.vacina.clinica.repository;

import com.estoque.vacina.clinica.model.entity.RegistroSaida;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RegistroSaidaRepository  extends JpaRepository<RegistroSaida, UUID> {
}

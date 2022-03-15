package com.dio.devweek.repository;

import com.dio.devweek.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepo extends JpaRepository<Incidencia, Long> {
}

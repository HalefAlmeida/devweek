package com.dio.devweek.repository;

import com.dio.devweek.entity.FaixaEtaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaixaEtariaRepo extends JpaRepository<FaixaEtaria, Long> {
}

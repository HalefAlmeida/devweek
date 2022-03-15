package com.dio.devweek.repository;

import com.dio.devweek.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface RegiaoRepo extends JpaRepository<Regiao, Long>{

}

package com.dio.devweek.controller;

import com.dio.devweek.entity.FaixaEtaria;
import com.dio.devweek.repository.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FaixaEtariaController {

    private final FaixaEtariaRepo repository;

    public FaixaEtariaController(FaixaEtariaRepo repository){
        this.repository = repository;
    }

    @GetMapping("/faixaetaria")
    public List<FaixaEtaria> getFaixaEtaria(){
        return repository.findAll();
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> getFaixaEtariaById(@PathVariable Long id){
        Optional faixaEtariaEscolhidaOptional = repository.findById(id);
        if (faixaEtariaEscolhidaOptional.isPresent()){
            Object faixaEtariaEscolhida = faixaEtariaEscolhidaOptional.get();
            return new ResponseEntity<>(faixaEtariaEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public void putFaixaEtaria(FaixaEtaria newFaixaEtaria){
        repository.save(newFaixaEtaria);
    }
}

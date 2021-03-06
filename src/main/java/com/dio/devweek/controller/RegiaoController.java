package com.dio.devweek.controller;

import com.dio.devweek.entity.Regiao;
import com.dio.devweek.repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegiaoController {

    private final RegiaoRepo repository;

    public RegiaoController(RegiaoRepo repository){
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
    return repository.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) {
        Optional regiaoEscolhidaOptional = repository.findById(id);
        if (regiaoEscolhidaOptional.isPresent()){
            Object regiaoEscolhida =  regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public void putRegiao(Regiao newRegiao){
        repository.save(newRegiao);
    }
}

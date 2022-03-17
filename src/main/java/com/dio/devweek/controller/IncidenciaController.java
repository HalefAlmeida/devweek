package com.dio.devweek.controller;

import com.dio.devweek.entity.Incidencia;
import com.dio.devweek.repository.IncidenciaRepo;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidenciaController {

    private final IncidenciaRepo repository;

    public IncidenciaController(IncidenciaRepo repository){
        this.repository = repository;
    }

    @GetMapping("/incidencia")
    public List<Incidencia> getIncidencia(){
        return repository.findAll();
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<?> getIncidenciaById(@PathVariable Long id){
        Optional incidenciaEscolhidaOptional = repository.findById(id);
        if (incidenciaEscolhidaOptional.isPresent()){
            Object incidenciaEscolhida = incidenciaEscolhidaOptional.get();
            return new ResponseEntity<>(incidenciaEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public void putIncidencia(Incidencia newIncidencia){
        repository.save(newIncidencia);
    }
}

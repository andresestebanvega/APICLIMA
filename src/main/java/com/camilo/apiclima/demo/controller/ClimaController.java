package com.camilo.apiclima.demo.controller;

import com.camilo.apiclima.demo.service.ClimaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ciudad") // Define la URL base para todos los métodos de la clase

public class ClimaController {

    private final ClimaService service;

    public ClimaController(ClimaService service) {
        this.service = service;
    }

    @GetMapping("/clima/{ciudad}")
    public ResponseEntity<String> obtenerClima(@PathVariable String ciudad){
        return service.obtenerClimaApi(ciudad);
    }
}

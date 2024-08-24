package com.camilo.apiclima.demo.controller;

import com.camilo.apiclima.demo.service.ClimaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudad") // Define la URL base para todos los métodos de la clase

public class ClimaController {

    private final ClimaService service;

    public ClimaController(ClimaService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:5173") // Permite que el servidor acepte peticiones de un origen diferente
    @GetMapping("/clima/{ciudad}")
    public ResponseEntity<String> obtenerClima(@PathVariable String ciudad){
        return service.obtenerClimaApi(ciudad);
    }
}

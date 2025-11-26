// src/main/java/org.testeveiculos.veiculosapi/controller/VeiculoController.java

package org.testeveiculos.Api.controller; // 🛑 PACOTE CONTROLLER


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testeveiculos.Api.model.Veiculo;
import org.testeveiculos.Api.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200") // 🛑 Essencial para o Angular
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    // ENDPOINT 1: Listar veículos (GET http://localhost:8080/api/veiculos)
    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    // ENDPOINT 2: Buscar veículo por ID (GET http://localhost:8080/api/veiculos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
        return veiculoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
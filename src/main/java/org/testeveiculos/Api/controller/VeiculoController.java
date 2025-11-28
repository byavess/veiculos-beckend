// src/main/java/org.testeveiculos.veiculosapi/controller/VeiculoController.java

package org.testeveiculos.Api.controller; // 🛑 PACOTE CONTROLLER


import org.springframework.web.bind.annotation.*;
import org.testeveiculos.Api.model.Veiculo;
import org.testeveiculos.Api.service.VeiculoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200") // 🛑 Essencial para o Angular
public class VeiculoController {

private final VeiculoService veiculoService;
public VeiculoController (VeiculoService veiculoService){
    this.veiculoService = veiculoService;
}


    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculoById(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.getVeiculoById(id);
        return veiculo.orElse(null);
    }

    @GetMapping("/marca/{marca}")
    public List<Veiculo> getVeiculosByMarca(@PathVariable String marca) {

        return veiculoService.getVeiculosByMarca(marca);
    }

    @GetMapping("/marcas")
    public List<String> getAllMarcas() {
        return veiculoService.getAllMarcas();
    }

    @GetMapping("/search")
    public List<Veiculo> searchVeiculos(@RequestParam(required = false) String q) {
        return veiculoService.searchVeiculos(q);
    }
}
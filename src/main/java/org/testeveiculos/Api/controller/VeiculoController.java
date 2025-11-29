// src/main/java/org.testeveiculos.veiculosapi/controller/VeiculoController.java

package org.testeveiculos.Api.controller; // 🛑 PACOTE CONTROLLER


import org.springframework.web.bind.annotation.*;
import org.testeveiculos.Api.model.Veiculo;
import org.testeveiculos.Api.service.VeiculoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200/public/home") // 🛑 Essencial para o Angular
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {

        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        // Método alternativo - cria lista manualmente
        List<Veiculo> veiculos = new ArrayList<>();

        // Adicione alguns veículos manualmente para teste
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setId(1L);
        veiculo1.setMarca("BMW");
        veiculo1.setModelo("X1");
        veiculo1.setPreco(250000.0);
        veiculo1.setUrlsFotos(Arrays.asList("http://localhost:8080/images/bmw/bmw.webp"));
        veiculos.add(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setId(2L);
        veiculo2.setMarca("Renault");
        veiculo2.setModelo("Duster");
        veiculo2.setPreco(120000.0);
        veiculo2.setUrlsFotos(Arrays.asList("http://localhost:8080/images/duster/duster.webp"));
        veiculos.add(veiculo2);

        return veiculos;
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
    @GetMapping("/teste-imagens")
    public String testeImagens() {
        return "✅ WebConfig está funcionando! Acesse: http://localhost:8080/images/veiculos/";
    }
    @GetMapping("/teste")
    public String teste() {
        return "✅ Backend funcionando!";
    }

}
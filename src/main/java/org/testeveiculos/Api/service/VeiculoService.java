// src/main/java/org.testeveiculos.veiculosapi/service/VeiculoService.java

package org.testeveiculos.Api.service; // 🛑 PACOTE SERVICE


import org.springframework.stereotype.Service;
import org.testeveiculos.Api.model.Veiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final List<Veiculo> veiculos = new ArrayList<>();

    public VeiculoService() {
        // Dados fictícios (um de cada marca)
        veiculos.addAll(Arrays.asList(
                new Veiculo(1L, "BMW", "X5", 2022, 120000.00, "Preto",
                        "https://via.placeholder.com/300x200?text=BMW+X5", "SUV de luxo."),
                new Veiculo(2L, "Audi", "A4", 2021, 65000.50, "Branco",
                        "https://via.placeholder.com/300x200?text=Audi+A4", "Sedan elegante."),
                new Veiculo(3L, "Mercedes", "Classe C", 2023, 85000.00, "Prata",
                        "https://via.placeholder.com/300x200?text=Mercedes+C", "Sofisticação alemã.")
                // Adicione mais veículos conforme o seu frontend precisar!
        ));
    }

    public List<Veiculo> findAll() {
        return veiculos;
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getId().equals(id))
                .findFirst();
    }
}
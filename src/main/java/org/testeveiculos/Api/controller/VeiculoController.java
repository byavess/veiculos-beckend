// src/main/java/org.testeveiculos.veiculosapi/controller/VeiculoController.java

package org.testeveiculos.Api.controller; // 🛑 PACOTE CONTROLLER


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testeveiculos.Api.model.Veiculo;
import org.testeveiculos.Api.service.VeiculoService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*") // 🛑 Essencial para o Angular
public class VeiculoController {

private final VeiculoService veiculoService;
public VeiculoController (VeiculoService veiculoService){
    this.veiculoService = veiculoService;
}

    private final Path imageDirectory = Paths.get("src/main/resources/images");

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculoById(@PathVariable("id") Long id) {
        Optional<Veiculo> veiculo = veiculoService.getVeiculoById(id);
        return veiculo.orElse(null);
    }

    @GetMapping("/marca/{marca}")
    public List<Veiculo> getVeiculosByMarca(@PathVariable("marca") String marca) {

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


    @GetMapping("/imagens")
    public ResponseEntity<Resource> getImagem(@RequestParam("path") String path) {
        try {
            if (path.contains("..")) {
                return ResponseEntity.badRequest().build();
            }

            Path imagePath = imageDirectory.resolve(path).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                String contentType = determineContentType(path);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    private String determineContentType(String filename) {
        if (filename.endsWith(".webp")) return "image/webp";
        if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) return "image/jpeg";
        if (filename.endsWith(".png")) return "image/png";
        return "application/octet-stream";
    }
}
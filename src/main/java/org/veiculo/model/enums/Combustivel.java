package org.veiculo.model.enums;

public enum Combustivel {
    ALCOOL("Álcool"),
    FLEX("Flex"),
    GASOLINA("Gasolina"),
    GNV("GNV"),
    DIESEL("Diesel"),
    ELETRICO("Elétrico"),
    HIBRIDO("Híbrido");

    private final String descricao;

    Combustivel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


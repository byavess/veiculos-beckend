package org.veiculo.model.enums;

public enum Cambio {
    MANUAL("Manual"),
    AUTOMATICO("Automático");

    private final String descricao;

    Cambio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}


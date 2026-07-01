package sistema.frota.entidades.abastecimento;

import lombok.Getter;

@Getter
public enum TipoCombustivel {
    GASOLINA("Gasolina"),
    ETANOL("Etanol"),
    DIESEL("Diesel");

    private final String descricao;

    TipoCombustivel(String descricao) {
        this.descricao = descricao;
    }
}

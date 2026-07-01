package sistema.frota.entidades.multa;

import lombok.Getter;

@Getter
public enum StatusMulta {
    PAGA("Paga"),
    RECORRIDA("Recorrida");

    private final String descricao;

    StatusMulta(String descricao) {
        this.descricao = descricao;
    }
}

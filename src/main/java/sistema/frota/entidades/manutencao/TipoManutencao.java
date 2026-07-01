package sistema.frota.entidades.manutencao;

import lombok.Getter;

@Getter
public enum TipoManutencao {
    PREVENTIVA("Preventiva"),
    CORRETIVA("Corretiva");

    private final String descricao;

    TipoManutencao(String descricao) {
        this.descricao = descricao;
    }
}

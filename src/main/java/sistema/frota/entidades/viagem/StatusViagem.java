package sistema.frota.entidades.viagem;

import lombok.Getter;

@Getter
public enum StatusViagem {
    EM_ANDAMENTO("Em Andamento"),
    FINALIZADA("Finalizada");

    private final String descricao;

    StatusViagem(String descricao) {
        this.descricao = descricao;
    }
}

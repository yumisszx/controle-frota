package sistema.frota.entidades.multa;

import lombok.Getter;

@Getter
public enum GravidadeMulta {
    LEVE("Leve"),
    MEDIA("Media"),
    GRAVE("Grave"),
    GRAVISSIMA("Gravíssima");

    private final String descricao;

    GravidadeMulta(String descricao) {
        this.descricao = descricao;
    }
}

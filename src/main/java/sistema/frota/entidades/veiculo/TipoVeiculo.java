package sistema.frota.entidades.veiculo;
import lombok.Getter;

@Getter
public enum TipoVeiculo {

    CARRO("Carro"),
    MOTO("Moto"),
    CAMINHONETE("Caminhonete"),
    VAN("Van"),
    MICRO_ONIBUS("Micro-ônibus"),
    ONIBUS("Ônibus"),
    CAMINHAO_LEVE("Caminhão Leve"),
    CAMINHAO_MEDIO("Caminhão Médio"),
    CAMINHAO_PESADO("Caminhão Pesado");

    private final String descricao;

    TipoVeiculo(String descricao) {
        this.descricao = descricao;
    }
}

package sistema.frota.entidades.abastecimento;

import sistema.frota.entidades.veiculo.Veiculo;
import java.time.LocalDate;

public record AbastecimentoRequestDTO(
    Veiculo veiculo,
    LocalDate data,
    TipoCombustivel tipo_combustivel,
    Double quantidade_litros,
    Double valor_litro,
    Integer km_veiculo
) {
}

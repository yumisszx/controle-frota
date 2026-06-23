package sistema.frota.entidades.manutencao;

import sistema.frota.entidades.veiculo.Veiculo;
import java.time.LocalDate;

public record ManutencaoRequestDTO(
        Veiculo veiculo,
        LocalDate data,
        TipoManutencao tipo,
        String descricao,
        String oficina_nome,
        Double valor,
        Integer km_veiculo
) {
}

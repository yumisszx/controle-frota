package sistema.frota.entidades.veiculo;

import java.time.Year;

public record VeiculoRequestDTO(
        String chassi,
        String renavam,
        String placa,
        TipoVeiculo tipo_veiculo,
        String marca,
        String modelo,
        Year ano,
        Integer km_atual,
        Double capacidade_carga
) {
}

package sistema.frota.entidades.abastecimento;

import sistema.frota.entidades.veiculo.Veiculo;
import java.time.LocalDate;

public record AbastecimentoResponseDTO(Integer id_abastecimento, Veiculo veiculo, LocalDate data, TipoCombustivel tipo_combustivel, Double quantidade_litros, Double valor_litro, Integer km_veiculo) {
    public AbastecimentoResponseDTO(Abastecimento abastecimento){
        this(abastecimento.getId_abastecimento(), abastecimento.getVeiculo(), abastecimento.getData(),abastecimento.getTipo_combustivel(), abastecimento.getQuantidade_litros(), abastecimento.getValor_litro(), abastecimento.getKm_veiculo());
    }
}

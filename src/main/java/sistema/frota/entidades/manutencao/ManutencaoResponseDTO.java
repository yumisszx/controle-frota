package sistema.frota.entidades.manutencao;

import sistema.frota.entidades.veiculo.Veiculo;
import java.time.LocalDate;

public record ManutencaoResponseDTO(Integer id_manutencao, Veiculo veiculo, LocalDate data, TipoManutencao tipo, String descricao, String oficina_nome, Double valor, Integer km_veiculo) {
    public ManutencaoResponseDTO(Manutencao manutencao) {
        this(manutencao.getId_manutencao(), manutencao.getVeiculo(), manutencao.getData(), manutencao.getTipo(), manutencao.getDescricao(), manutencao.getOficina_nome(), manutencao.getValor(), manutencao.getKm_veiculo());
    }
}
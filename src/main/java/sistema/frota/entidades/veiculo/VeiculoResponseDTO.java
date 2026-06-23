package sistema.frota.entidades.veiculo;

import java.time.Year;

public record VeiculoResponseDTO(String chassi, String renavam, String placa, TipoVeiculo tipo_veiculo, String marca, String modelo, Year ano, Integer km_atual, Double capacidade_carga) {
    public VeiculoResponseDTO(Veiculo veiculo){
        this(veiculo.getChassi(), veiculo.getRenavam(), veiculo.getPlaca(), veiculo.getTipo_veiculo(),
                veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getKm_atual(),  veiculo.getCapacidade_carga());
    }
}

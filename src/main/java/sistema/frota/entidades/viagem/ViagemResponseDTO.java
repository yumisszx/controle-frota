package sistema.frota.entidades.viagem;

import sistema.frota.entidades.cidades.Cidades;
import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalTime;

public record ViagemResponseDTO(Integer id_viagem, Veiculo veiculo, Motorista motorista, Cidades origem, Cidades destino, LocalDate data_saida, LocalDate data_chegada, LocalTime hora_saida, LocalTime hora_chegada, Integer km_inicial, Integer km_final, StatusViagem status) {
    public ViagemResponseDTO(Viagem viagem){
        this(viagem.getId_viagem(), viagem.getVeiculo(), viagem.getMotorista(), viagem.getOrigem(), viagem.getDestino(), viagem.getData_saida(), viagem.getData_chegada(), viagem.getHora_saida(), viagem.getHora_chegada(), viagem.getKm_inicial(),  viagem.getKm_final(), viagem.getStatus());
    }
}

package sistema.frota.entidades.multa;

import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalTime;

public record MultaResponseDTO(Integer id_multa, Veiculo veiculo, Motorista motorista, LocalDate data, LocalTime hora, GravidadeMulta gravidade, Double valor, Integer pontos_cnh, StatusMulta status) {
    public MultaResponseDTO(Multa multa){
        this(multa.getId_multa(), multa.getVeiculo(), multa.getMotorista(), multa.getData(), multa.getHora(), multa.getGravidade(),multa.getValor(),multa.getPontos_cnh(),multa.getStatus());
    }
}

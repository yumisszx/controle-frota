package sistema.frota.entidades.multa;

import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.veiculo.Veiculo;
import java.time.LocalDate;
import java.time.LocalTime;

public record MultaRequestDTO(
        Veiculo veiculo,
        Motorista motorista,
        LocalDate data,
        LocalTime hora,
        GravidadeMulta gravidade,
        Double valor,
        Integer pontos_cnh,
        StatusMulta status
) {
}

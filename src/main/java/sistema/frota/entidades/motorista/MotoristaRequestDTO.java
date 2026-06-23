package sistema.frota.entidades.motorista;

import java.time.LocalDate;

public record MotoristaRequestDTO(
        String CPF,
        String nome,
        LocalDate dataNascimento,
        String telefone,
        String CNH,
        CategoriaCNH categoria,
        LocalDate validade_cnh
) {
}

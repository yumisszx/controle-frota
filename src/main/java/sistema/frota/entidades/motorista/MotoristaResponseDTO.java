package sistema.frota.entidades.motorista;

import java.time.LocalDate;

public record MotoristaResponseDTO(String CPF, String nome, LocalDate dataNascimento, String telefone, String CNH, CategoriaCNH categoria, LocalDate validade_cnh) {
}

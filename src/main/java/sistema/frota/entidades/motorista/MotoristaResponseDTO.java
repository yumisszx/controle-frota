package sistema.frota.entidades.motorista;

import java.time.LocalDate;

public record MotoristaResponseDTO(String CPF, String nome, LocalDate dataNascimento, String telefone, String CNH, CategoriaCNH categoria, LocalDate validade_cnh) {
    public MotoristaResponseDTO(Motorista motorista){
        this(motorista.getCPF(), motorista.getNome(), motorista.getDataNascimento(), motorista.getTelefone(), motorista.getCNH(),  motorista.getCategoria(), motorista.getValidade_cnh());
    }
}

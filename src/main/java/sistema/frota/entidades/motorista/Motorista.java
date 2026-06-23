package sistema.frota.entidades.motorista;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "motorista")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "CPF")
public class Motorista {
    @Id
    @NonNull
    @Column(columnDefinition = "VARCHAR(11)", unique = true)
    private String CPF;

    @NonNull
    private String nome;

    @NonNull
    private LocalDate dataNascimento;

    @NonNull
    @Column(columnDefinition = "VARCHAR(15)")
    private String telefone;

    @NonNull
    @Column(columnDefinition = "VARCHAR(11)", unique = true)
    private String CNH;

    @NonNull
    @Enumerated(EnumType.STRING)
    private CategoriaCNH categoria;

    @NonNull
    private LocalDate validade_cnh;
}

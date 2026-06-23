package sistema.frota.multa;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.motorista.Motorista;
import sistema.frota.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "multa")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_multa")
public class Multa {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_multa;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "motorista")
    private Motorista motorista;

    @NonNull
    private LocalDate data;

    @NonNull
    private LocalTime hora;

    @NonNull
    @Enumerated(EnumType.STRING)
    private GravidadeMulta gravidade;

    @NonNull
    private Double valor;

    @NonNull
    private Integer pontos_cnh;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusMulta status;
}

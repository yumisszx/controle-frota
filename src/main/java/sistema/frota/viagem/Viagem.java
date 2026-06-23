package sistema.frota.viagem;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.cidades.Cidades;
import sistema.frota.motorista.Motorista;
import sistema.frota.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "viagem")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_viagem")
public class Viagem {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_viagem;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "motorista")
    private Motorista motorista;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Cidades origem;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Cidades destino;

    @NonNull
    private LocalDate data_saida;

    private LocalDate data_chagada;

    @NonNull
    private LocalTime hora_saida;

    private LocalTime hora_chagada;

    @NonNull
    private Integer km_inicial;

    private Integer km_final;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusViagem status;
}

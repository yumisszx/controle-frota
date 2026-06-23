package sistema.frota.entidades.abastecimento;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.entidades.veiculo.Veiculo;

import java.time.LocalDate;

@Table(name = "abastecimento")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_abastecimento")
public class Abastecimento {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_abastecimento;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @NonNull
    private LocalDate data;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipo_combustivel;

    @NonNull
    private Double quantidade_litros;

    @NonNull
    private Double valor_litro;

    @NonNull
    private Integer km_veiculo;
}
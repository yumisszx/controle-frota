package sistema.frota.abastecimento;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.veiculo.Veiculo;

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
    @JoinColumn(name = "veiculo_chassi")
    private Veiculo veiculo;

    @NonNull
    private LocalDate data;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipo_combustivel;

    @NonNull
    @Column(precision = 8, scale = 2)
    private Double quantidade_litros;

    @NonNull
    @Column(precision = 10, scale = 2)
    private Double valor;

    @NonNull
    private Integer km_veiculo;
}
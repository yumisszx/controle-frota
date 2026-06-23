package sistema.frota.manutencao;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.motorista.CategoriaCNH;
import sistema.frota.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "manutencao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id_manutencao;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "veiculo")
    private Veiculo veiculo;

    @NonNull
    private LocalDate data;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoManutencao tipo;

    @NonNull
    @Column(columnDefinition = "VARCHAR(500)")
    private String descricao;

    @NonNull
    private String oficina_nome;

    @NonNull
    private Double valor;

    @NonNull
    private Integer km_veiculo;
}

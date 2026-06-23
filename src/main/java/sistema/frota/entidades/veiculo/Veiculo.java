package sistema.frota.entidades.veiculo;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Table(name = "veiculo")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "chassi")

public class Veiculo {
    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    @NonNull
    private String chassi;

    @Column(columnDefinition = "VARCHAR(11)")
    @NonNull
    private String renavam;

    @Column(columnDefinition = "VARCHAR(7)")
    @NonNull
    private String placa;

    @Enumerated(EnumType.STRING)
    @NonNull
    private TipoVeiculo tipo_veiculo;

    @NonNull
    private String marca;

    @NonNull
    private String modelo;

    @NonNull
    private Year ano;

    @NonNull
    private Integer km_atual;

    @NonNull
    private Double capacidade_carga;
}

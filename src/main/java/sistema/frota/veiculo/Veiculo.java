package sistema.frota.veiculo;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "VARCHAR(17)")
    @NonNull
    private String chassi;

    @Column(columnDefinition = "VARCHAR(11)")
    @NonNull
    private String renavam;

    @Column(columnDefinition = "VARCHAR(7)")
    @NonNull
    private String placa;

    @NonNull
    private String marca;

    @NonNull
    private String modelo;

    @NonNull
    private Year ano;

    @NonNull
    private int km_atual;

    @NonNull
    @Column(precision = 10, scale = 2)
    private double capacidade_carga;
}

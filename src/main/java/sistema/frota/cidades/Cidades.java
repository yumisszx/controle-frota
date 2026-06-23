package sistema.frota.cidades;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cidades", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"cidade", "estado"}
        )
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_cidade")
public class Cidades {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cidade;

    @NonNull
    private String cidade;

    @NonNull
    @Column(columnDefinition = "VARCHAR(2)")
    private String estado;

    @NonNull
    private String pais;
}

package sistema.frota.entidades.viagem;

import jakarta.persistence.*;
import lombok.*;
import sistema.frota.entidades.cidades.Cidades;
import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.veiculo.Veiculo;

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

    private LocalDate data_chegada;

    @NonNull
    private LocalTime hora_saida;

    private LocalTime hora_chegada;

    @NonNull
    private Integer km_inicial;

    private Integer km_final;

    @NonNull
    @Enumerated(EnumType.STRING)
    private StatusViagem status;

    public Viagem(ViagemRequestDTO data, Veiculo veiculo, Motorista motorista){
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.origem = origem;
        this.destino = destino;
        this.data_saida = data.data_saida();
        this.hora_saida = data.hora_saida();
        this.km_inicial = data.km_inicial();
        this.status = data.status();
    }

    public void ViagemSave(ViagemRequestDTO data){
        this.data_chegada = data.data_chegada();
        this.hora_chegada = data.hora_chegada();
        this.km_final = data.km_final();
        this.status = data.status();
    }
}

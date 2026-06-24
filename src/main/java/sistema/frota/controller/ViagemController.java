package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.motorista.MotoristaRepository;
import sistema.frota.entidades.veiculo.Veiculo;
import sistema.frota.entidades.veiculo.VeiculoRepository;
import sistema.frota.entidades.viagem.Viagem;
import sistema.frota.entidades.viagem.ViagemRepository;
import sistema.frota.entidades.viagem.ViagemRequestDTO;
import sistema.frota.entidades.viagem.ViagemResponseDTO;

import java.util.List;

@RestController
@RequestMapping("viagem")
public class ViagemController {

    private final ViagemRepository repository;
    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;

    public ViagemController(ViagemRepository repository, VeiculoRepository veiculoRepository, MotoristaRepository motoristaRepository) {
        this.repository = repository;
        this.veiculoRepository = veiculoRepository;
        this.motoristaRepository = motoristaRepository;
    }

    @PostMapping
    public String openViagem(@RequestBody ViagemRequestDTO data){
        Veiculo veiculo = veiculoRepository.findById(data.veiculo().getChassi())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        Motorista motorista = motoristaRepository.findById(data.motorista().getCPF())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

        Viagem viagemData =  new Viagem(data, veiculo, motorista);
        repository.save(viagemData);

        return "Viagem aberta com sucesso";
    }

    @PutMapping("/{id_viagem}")
    public String closeViagem (@PathVariable Integer id_viagem,@RequestBody ViagemRequestDTO data){
        Viagem viagem = repository.findById(id_viagem).orElseThrow(() -> new RuntimeException("Viagem não encontrada"));

        viagem.ViagemSave(data);
        repository.save(viagem);

        return "Viagem finalizada com sucesso";
    }

    @GetMapping
    public List<ViagemResponseDTO> viagemAll(){
        List<ViagemResponseDTO> viagemList = repository.findAll().stream().map(ViagemResponseDTO::new).toList();

        return viagemList;
    }

    @DeleteMapping("/{id_viagem}")
    public String deleteViagem(@PathVariable Integer id_viagem){
        repository.deleteById(id_viagem);

        return "Viagem deletada com sucesso";
    }
}

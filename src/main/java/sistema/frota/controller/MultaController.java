package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.manutencao.ManutencaoRequestDTO;
import sistema.frota.entidades.motorista.Motorista;
import sistema.frota.entidades.motorista.MotoristaRepository;
import sistema.frota.entidades.multa.Multa;
import sistema.frota.entidades.multa.MultaRepository;
import sistema.frota.entidades.multa.MultaRequestDTO;
import sistema.frota.entidades.multa.MultaResponseDTO;
import sistema.frota.entidades.veiculo.Veiculo;
import sistema.frota.entidades.veiculo.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("multa")
public class MultaController {

    private final MultaRepository repository;
    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;

    public MultaController(MultaRepository repository, VeiculoRepository veiculoRepository, MotoristaRepository motoristaRepository) {
        this.repository = repository;
        this.veiculoRepository = veiculoRepository;
        this.motoristaRepository = motoristaRepository;
    }

    @PostMapping
    public String newMulta(@RequestBody MultaRequestDTO data) {
        Veiculo veiculo = veiculoRepository.findById(data.veiculo().getChassi())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        Motorista motorista = motoristaRepository.findById(data.motorista().getCPF())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

        Multa multaData = new Multa(data, veiculo, motorista);
        repository.save(multaData);

        return "Multa registrada com sucesso";
    }

    @GetMapping
    public List<MultaResponseDTO> multaAll(){
        List<MultaResponseDTO> multaList = repository.findAll().stream().map(MultaResponseDTO::new).toList();

        return multaList;
    }
}

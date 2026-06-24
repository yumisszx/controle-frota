package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.manutencao.Manutencao;
import sistema.frota.entidades.manutencao.ManutencaoRepository;
import sistema.frota.entidades.manutencao.ManutencaoRequestDTO;
import sistema.frota.entidades.manutencao.ManutencaoResponseDTO;
import sistema.frota.entidades.veiculo.Veiculo;
import sistema.frota.entidades.veiculo.VeiculoRepository;

import java.util.List;

@RestController
@RequestMapping("manutencao")
public class ManutencaoController {

    private final ManutencaoRepository repository;
    private final VeiculoRepository veiculoRepository;

    public ManutencaoController(ManutencaoRepository repository, VeiculoRepository veiculoRepository) {
        this.repository = repository;
        this.veiculoRepository = veiculoRepository;
    }

    @PostMapping
    public String newManutencao(@RequestBody ManutencaoRequestDTO data){
        Veiculo veiculo = veiculoRepository.findById(data.veiculo().getChassi())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        Manutencao manutencaoData = new Manutencao(data, veiculo);
        repository.save(manutencaoData);

        return "Manutenção registrada com sucesso";
    }

    @GetMapping
    public List<ManutencaoResponseDTO> ManutencaoAll(){
        List<ManutencaoResponseDTO> manutencaoList = repository.findAll().stream().map(ManutencaoResponseDTO::new).toList();

        return manutencaoList;
    }
}

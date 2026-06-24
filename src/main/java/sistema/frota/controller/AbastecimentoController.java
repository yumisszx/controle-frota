package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.abastecimento.Abastecimento;
import sistema.frota.entidades.abastecimento.AbastecimentoRepository;
import sistema.frota.entidades.abastecimento.AbastecimentoRequestDTO;
import sistema.frota.entidades.abastecimento.AbastecimentoResponseDTO;
import sistema.frota.entidades.veiculo.Veiculo;
import sistema.frota.entidades.veiculo.VeiculoRepository;
import java.util.List;

@RestController
@RequestMapping("abastecimento")
public class AbastecimentoController {

    private final AbastecimentoRepository repository;
    private final VeiculoRepository veiculoRepository;

    public AbastecimentoController(AbastecimentoRepository repository, VeiculoRepository veiculoRepository){
        this.repository = repository;
        this.veiculoRepository = veiculoRepository;
    }

    @PostMapping
    public String newAbastecimento(@RequestBody AbastecimentoRequestDTO data){
        Veiculo veiculo = veiculoRepository.findById(data.veiculo().getChassi())
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        Abastecimento abastecimentoData = new Abastecimento(data, veiculo);
        repository.save(abastecimentoData);

        return "Abastecimento registrado com sucesso";
    }

    @GetMapping
    public List<AbastecimentoResponseDTO> abastecimentoAll(){
        List<AbastecimentoResponseDTO> abastecimentoList = repository.findAll().stream().map(AbastecimentoResponseDTO::new).toList();

        return abastecimentoList;
    }
}

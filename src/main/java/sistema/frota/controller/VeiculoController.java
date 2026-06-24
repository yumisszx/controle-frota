package sistema.frota.controller;

import org.springframework.web.bind.annotation.*;
import sistema.frota.entidades.veiculo.Veiculo;
import sistema.frota.entidades.veiculo.VeiculoRepository;
import sistema.frota.entidades.veiculo.VeiculoRequestDTO;
import sistema.frota.entidades.veiculo.VeiculoResponseDTO;

import java.util.List;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {
    private final VeiculoRepository repository;

    public VeiculoController(VeiculoRepository repository) {this.repository = repository;}

    @PostMapping
    public String newVeiculo(@RequestBody VeiculoRequestDTO data){
        Veiculo veiculoData = new Veiculo(data);
        repository.save(veiculoData);
        return "Veiculo adicionado com sucesso";
    }

    @DeleteMapping("/{chassi}")
    public String deleteVeiculo(@PathVariable String chassi){
        repository.deleteById(chassi);
        return "Veiculo removido com sucesso";
    }

    @GetMapping
    public List<VeiculoResponseDTO> findVeiculoAll(){
        List<VeiculoResponseDTO> veiculoList = repository.findAll().stream().map(VeiculoResponseDTO::new).toList();
        return veiculoList;
    }

    @PutMapping("/{chassi}")
    public String updateKm(@PathVariable String chassi, @RequestBody VeiculoRequestDTO data){
        Veiculo veiculo = repository.findById(chassi).orElseThrow(() -> new RuntimeException("Veiculo nao encontrado"));

        veiculo.updateKm(data);
        repository.save(veiculo);
        return "Veiculo atualizado com sucesso";
    }
}
